package ca.me.proj.service.employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.employee.EmployeeDTO;
import ca.me.proj.dtos.employee.NewEmployeeDTO;
import ca.me.proj.exceptions.ResourceNotFoundException;
import ca.me.proj.mapper.employee.IEmployeeMapper;
import ca.me.proj.repository.branch.IBranchRepository;
import ca.me.proj.repository.employee.IEmployeeRepository;
import ca.me.proj.service.profile.ProfileService;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeMapper mapper;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IBranchRepository branchRepository;

    public List<EmployeeDTO> findAll() {
        return mapper.entityToDto(employeeRepository.findAll());
    }

    public List<EmployeeDTO> findDentistByBranchId(String branchId) {
        return mapper.entityToDto(employeeRepository.findDentistByBranchId(branchId));
    }

    public EmployeeDTO createEmployee(EmployeeDTO dto) {

        dto.setId(null);

        // @Jake Validation needed here?
        // createValidation(dto);

        if (profileService.existsByUsername(dto.getId())) {
            return save(dto);
        }

        dto.setProfile(profileService.createProfile(dto.getProfile()));
        return save(dto);

    }

    public NewEmployeeDTO createEmployee(NewEmployeeDTO dto) {

        return mapper.dtoToLite(createEmployee(mapper.liteToDto(dto)));

    }

    public void deleteEmployeeByID(String id) {
        deleteValidation(id);
        employeeRepository.deleteByID(id);
    }

    public boolean existsByID(String id) {
        return employeeRepository.existsByID(id);
    }

    public EmployeeDTO findByID(String id) {
        return mapper.entityToDto(employeeRepository.findByID(id));
    }

    public EmployeeDTO save(EmployeeDTO dto) {
        return mapper.entityToDto(employeeRepository.save(mapper.dtoToEntity(dto)));
    }

    public void createValidation(EmployeeDTO dto) {

        // If ID does not exist in Profile repo
        if (!profileService.existsByID(dto.getId())) {
            throw new ResourceNotFoundException(
                    "Profile with id " + dto.getId() + " does not exist");
        }

        // If Employee Role is incorrectly formated
        if (!dto.getRole().equals("MANAGER") && !dto.getRole().equals("RECEPTIONIST")
                && !dto.getRole().equals("DENTIST") && !dto.getRole().equals("HYGIENIST")) {
            throw new IllegalArgumentException("Invalid Employee Role: " + dto.getRole());

        }

        // If Employee type is incorrectly formated
        if (!dto.getType().equals("FT") && !dto.getType().equals("PT")) {
            throw new IllegalArgumentException("Invalid Employee Type: " + dto.getType());
        }

        // If Employee Salary is less than or equal to 0
        if (dto.getSalary() <= 0) {
            throw new IllegalArgumentException("Salary must be greater than 0: " + dto.getSalary());
        }

        // If Branch does not exist
        if (!branchRepository.existsByID(dto.getBranch().getId())) {
            throw new ResourceNotFoundException(
                    "Branch with id " + dto.getBranch().getId() + " does not exist");

        }
        // If ManagerID does not exists
        else if (dto.getBranch().getManager() != null && !employeeRepository
                .existsByID(dto.getBranch().getManager().getProfile().getId())) {
            throw new ResourceNotFoundException("Manager with id "
                    + dto.getBranch().getManager().getProfile().getId() + " does not exist");
        }
    }

    public void deleteValidation(String id) {
        if (!existsByID(id)) {
            throw new ResourceNotFoundException("Employee with id " + id + " does not exist");
        }
    }

}
