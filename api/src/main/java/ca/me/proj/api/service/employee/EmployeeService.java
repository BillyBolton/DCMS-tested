package ca.me.proj.api.service.employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.api.dtos.employee.EmployeeDTO;
import ca.me.proj.api.dtos.employee.EmployeeRole;
import ca.me.proj.api.dtos.employee.NewEmployeeDTO;
import ca.me.proj.api.dtos.exceptions.ResourceNotFoundException;
import ca.me.proj.api.entity.employee.EmployeeEntity;
import ca.me.proj.api.mapper.employee.IEmployeeMapper;
import ca.me.proj.api.repository.branch.IBranchRepository;
import ca.me.proj.api.repository.employee.IEmployeeRepository;
import ca.me.proj.api.service.base.AbstractBaseServiceImpl;
import ca.me.proj.api.service.profile.ProfileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService extends AbstractBaseServiceImpl<EmployeeDTO, EmployeeEntity, String> {

    @Autowired
    private IEmployeeMapper employeeMapper;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private IBranchRepository branchRepository;


    public List<EmployeeDTO> findDentistByBranchId(String branchId) {
        return mapper.entityToDto(
                employeeRepository.findByRoleAndBranchId(EmployeeRole.DENTIST, branchId));
    }

    public EmployeeDTO createEmployee(EmployeeDTO dto) {

        // dto.setId(null);

        // @Jake Validation needed here?
        // createValidation(dto);

        if (profileService.existsByUsername(dto.getProfile().getUsername())) {
            log.info("Username already exists: {}", dto);
            dto.setProfile(profileService.findByUsername(dto.getProfile().getUsername()));
            dto.setId(dto.getProfile().getId());
            return save(dto);
        }

        dto.setProfile(profileService.createProfile(dto.getProfile()));
        return save(dto);

    }

    public NewEmployeeDTO createEmployee(NewEmployeeDTO dto) {
        return employeeMapper.dtoToLite(createEmployee(employeeMapper.liteToDto(dto)));

    }



    public void createValidation(EmployeeDTO dto) {

        // If ID does not exist in Profile repo
        if (!profileService.existsById(dto.getId())) {
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
        if (!branchRepository.existsById(dto.getBranch().getId())) {
            throw new ResourceNotFoundException(
                    "Branch with id " + dto.getBranch().getId() + " does not exist");

        }
        // If ManagerID does not exists
        else if (dto.getBranch().getManager() != null && !employeeRepository
                .existsById(dto.getBranch().getManager().getProfile().getId())) {
            throw new ResourceNotFoundException("Manager with id "
                    + dto.getBranch().getManager().getProfile().getId() + " does not exist");
        }
    }



    public EmployeeDTO update(EmployeeDTO dto) {


        dto.setProfile(profileService.update(dto.getProfile()));
        dto.getProfile().setDOB(dto.getProfile().getDOB().plusDays(1L));

        return super.update(dto);
    }

}
