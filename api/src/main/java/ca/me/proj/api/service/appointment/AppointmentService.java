package ca.me.proj.api.service.appointment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.api.dtos.appointment.AppointmentDTO;
import ca.me.proj.api.dtos.exceptions.ResourceNotFoundException;
import ca.me.proj.api.entity.appointment.AppointmentEntity;
import ca.me.proj.api.repository.appointment.IAppointmentRepository;
import ca.me.proj.api.repository.branch.IBranchRepository;
import ca.me.proj.api.repository.employee.IEmployeeRepository;
import ca.me.proj.api.repository.patient.IPatientRepository;
import ca.me.proj.api.service.base.AbstractBaseServiceImpl;

@Service
public class AppointmentService
        extends AbstractBaseServiceImpl<AppointmentDTO, AppointmentEntity, Long> {

    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IBranchRepository branchRepository;



    public AppointmentDTO createAppointment(AppointmentDTO dto) {
        createValidation(dto);
        return save(dto);
    }


    public List<AppointmentDTO> findByPatientId(String id) {
        return mapper.entityToDto(appointmentRepository.findByPatientId(id));
    }

    public List<AppointmentDTO> findByEmployeeId(String id) {
        return mapper.entityToDto(appointmentRepository.findByEmployeeId(id));
    }

    public boolean findPatientScheduleConflict(AppointmentDTO dto) {
        AppointmentEntity entity = mapper.dtoToEntity(dto);
        return appointmentRepository.findPatientScheduleConflict(entity.getStartTime(),
                entity.getEndTime(), dto.getPatientId());
    }

    public boolean findEmployeeScheduleConflict(AppointmentDTO dto) {
        AppointmentEntity entity = mapper.dtoToEntity(dto);
        return appointmentRepository.findEmployeeScheduleConflict(entity.getStartTime(),
                entity.getEndTime(), dto.getEmployeeId());
    }


    private void createValidation(AppointmentDTO dto) {

        AppointmentEntity entity = mapper.dtoToEntity(dto);

        if (!branchRepository.existsById(entity.getBranchId())) {
            throw new ResourceNotFoundException(
                    "A branch with id " + entity.getBranchId() + " does not exist");
        }

        if (!employeeRepository.existsById(entity.getEmployeeId())) {
            throw new ResourceNotFoundException(
                    "An employee with id " + entity.getEmployeeId() + " does not exist");
        }

        if (!patientRepository.existsById(entity.getPatientId())) {
            throw new ResourceNotFoundException(
                    "A patient with id " + entity.getPatientId() + " does not exist");
        }

        if (entity.getStartTime().after(entity.getEndTime())) {
            throw new IllegalArgumentException("Start time must be before end time");
        }

        if (appointmentRepository.findPatientScheduleConflict(entity.getStartTime(),
                entity.getEndTime(), entity.getPatientId())) {
            throw new IllegalArgumentException("Patient already has an appointment at that time");
        }

        if (appointmentRepository.findEmployeeScheduleConflict(entity.getStartTime(),
                entity.getEndTime(), entity.getEmployeeId())) {
            throw new IllegalArgumentException("Employee already has an appointment at that time");
        }
    }



}
