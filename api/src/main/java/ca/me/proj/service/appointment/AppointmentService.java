package ca.me.proj.service.appointment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.appointment.AppointmentDTO;
import ca.me.proj.entity.appointment.AppointmentEntity;
import ca.me.proj.entity.response.CustomResponseEntity;
import ca.me.proj.mapper.appointment.IAppointmentMapper;
import ca.me.proj.repository.appointment.IAppointmentRepository;
import ca.me.proj.repository.branch.IBranchRepository;
import ca.me.proj.repository.employee.IEmployeeRepository;
import ca.me.proj.repository.patient.IPatientRepository;

@Service
public class AppointmentService {

    @Autowired
    private IAppointmentMapper mapper;

    @Autowired
    private IAppointmentRepository repository;

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IBranchRepository branchRepository;

    public List<AppointmentDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public AppointmentDTO findById(Long id) {
        return mapper.entityToDto(repository.findById(id).orElse(null));
    }

    public ResponseEntity<String> createAppointment(AppointmentDTO dto) {
        dto.setId(null);
        AppointmentEntity entity = mapper.dtoToEntity(dto);
        if (!branchRepository.existsById(entity.getBranchId())) {
            return CustomResponseEntity.badRequestInvalidArgument("Branch ID does not exist");
        } else if (!employeeRepository.existsById(entity.getEmployeeId())) {
            return CustomResponseEntity.badRequestInvalidArgument("Employee ID does not exist");
        } else if (!patientRepository.existsById(entity.getPatientId())) {
            return CustomResponseEntity.badRequestInvalidArgument("Patient ID does not exist");
        } else if (entity.getStartTime().after(entity.getEndTime())) {
            return CustomResponseEntity.badRequestInvalidArgument("Start time is before end time");
        } else if (repository.findPatientScheduleConflict(entity.getStartTime(),
                entity.getEndTime(), entity.getPatientId())) {
            return CustomResponseEntity.badRequestInvalidArgument("Patient has schedule conflict");
        } else if (repository.findEmployeeScheduleConflict(entity.getStartTime(),
                entity.getEndTime(), entity.getEmployeeId())) {
            return CustomResponseEntity.badRequestInvalidArgument("Employee has schedule conflict");
        } else {
            repository.save(entity);
            return CustomResponseEntity.saveSuccess();
        }
    }

    public ResponseEntity<String> deletebyId(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return CustomResponseEntity.deleteSuccess();
        } else {
            return CustomResponseEntity.badRequestDNE();
        }
    }

    public List<AppointmentDTO> findByPatientId(String id) {
        return mapper.entityToDto(repository.findByPatientId(id));
    }

    public List<AppointmentDTO> findByEmployeeId(String id) {
        return mapper.entityToDto(repository.findByEmployeeId(id));
    }

    public boolean findPatientScheduleConflict(AppointmentDTO dto) {
        AppointmentEntity entity = mapper.dtoToEntity(dto);
        return repository.findPatientScheduleConflict(entity.getStartTime(), entity.getEndTime(),
                dto.getPatientId());
    }

    public boolean findEmployeeScheduleConflict(AppointmentDTO dto) {
        AppointmentEntity entity = mapper.dtoToEntity(dto);
        return repository.findEmployeeScheduleConflict(entity.getStartTime(), entity.getEndTime(),
                dto.getEmployeeId());
    }

}
