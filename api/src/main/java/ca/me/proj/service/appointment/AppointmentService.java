package ca.me.proj.service.appointment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.appointment.AppointmentDTO;
import ca.me.proj.entity.appointment.AppointmentEntity;
import ca.me.proj.exceptions.ResourceNotFoundException;
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

    public boolean existsByID(long id) {
        return repository.existsByID(id);
    }

    public AppointmentDTO findByID(long id) {
        if (!existsByID(id)) {
            throw new ResourceNotFoundException("Entity with id: " + id + " not found");
        }
        return mapper.entityToDto(repository.findByID(id));
    }

    public AppointmentDTO createAppointment(AppointmentDTO dto) {
        createValidation(dto);
        return save(dto);
    }

    public void deletebyId(long id) {
        deleteValidation(id);
        repository.deleteByID(id);
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

    public AppointmentDTO save(AppointmentDTO dto) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

    private void createValidation(AppointmentDTO dto) {
        AppointmentEntity entity = mapper.dtoToEntity(dto);
        if (!branchRepository.existsByID(entity.getBranchId())) {
            throw new ResourceNotFoundException(
                    "A branch with id " + entity.getBranchId() + " does not exist");
        } else if (!employeeRepository.existsByID(entity.getEmployeeId())) {
            throw new ResourceNotFoundException(
                    "An employee with id " + entity.getEmployeeId() + " does not exist");
        } else if (!patientRepository.existsByID(entity.getPatientId())) {
            throw new ResourceNotFoundException(
                    "A patient with id " + entity.getPatientId() + " does not exist");
        } else if (entity.getStartTime().after(entity.getEndTime())) {
            throw new IllegalArgumentException("Start time must be before end time");
        } else if (repository.findPatientScheduleConflict(entity.getStartTime(),
                entity.getEndTime(), entity.getPatientId())) {
            throw new IllegalArgumentException("Patient already has an appointment at that time");
        } else if (repository.findEmployeeScheduleConflict(entity.getStartTime(),
                entity.getEndTime(), entity.getEmployeeId())) {
            throw new IllegalArgumentException("Employee already has an appointment at that time");
        }
    }

    public void deleteValidation(long id) {
        if (!existsByID(id)) {
            throw new ResourceNotFoundException("An entity with id " + id + " does not exist");
        }
    }

    public AppointmentDTO update(AppointmentDTO dto) {
        if (!existsByID(dto.getId())) {
            throw new ResourceNotFoundException(
                    "Entity with id: " + dto.getId() + " does not exist");
        }
        return save(dto);
    }


}
