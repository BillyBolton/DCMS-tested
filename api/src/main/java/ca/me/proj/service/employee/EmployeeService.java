package ca.me.proj.service.employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.employee.EmployeeDTO;
import ca.me.proj.entity.response.CustomResponseEntity;
import ca.me.proj.mapper.employee.IEmployeeMapper;
import ca.me.proj.repository.branch.IBranchRepository;
import ca.me.proj.repository.employee.IEmployeeRepository;
import ca.me.proj.repository.profile.IProfileRepository;
import ca.me.proj.service.profile.ProfileService;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeMapper mapper;

    @Autowired
    private IProfileRepository profileRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IBranchRepository branchRepository;

    @Autowired
    private ProfileService profileService;

    public List<EmployeeDTO> findAll() {
        return mapper.entityToDto(employeeRepository.findAll());
    }

    public List<EmployeeDTO> findDentistByBranchId(String branchId) {
        return mapper.entityToDto(employeeRepository.findDentistByBranchId(branchId));
    }

    public EmployeeDTO createEmployee(EmployeeDTO dto) {

        /*
        // If ID does not exist in Profile repo
        //if (!profileRepository.existsById(dto.getId())) {
           // return CustomResponseEntity.badRequestDNE();
        //}


        // If Employee Role is incorrectly formated
        if (!dto.getRole().equals("MANAGER") && !dto.getRole().equals("RECEPTIONIST")
                && !dto.getRole().equals("DENTIST") && !dto.getRole().equals("HYGIENIST")) {
            return new ResponseEntity<>("Invalid Employee Role: " + dto.getRole(),
                    HttpStatus.BAD_REQUEST);

        }

        // If Employee type is incorrectly formated
        else if (!dto.getType().equals("FT") && !dto.getType().equals("PT")) {
            return new ResponseEntity<>("Invalid Employee Type: " + dto.getType(),
                    HttpStatus.BAD_REQUEST);
        }

        // If Employee Salary is less than or equal to 0
        else if (dto.getSalary() <= 0) {
            return new ResponseEntity<>("Salary must be > 0: " + dto.getSalary(),
                    HttpStatus.BAD_REQUEST);
        }

        // If Branch does not exist
        else if (!branchRepository.existsById(dto.getBranch().getId())) {
            return new ResponseEntity<>("Branch ID does not exist " + dto.getBranch().getId(),
                    HttpStatus.BAD_REQUEST);

            // }
            // // If ManagerID does not exists
            // else if (dto.getManagerID() != null &&
            // !employeeRepository.existsById(dto.getManagerID())) {
            // return new ResponseEntity<>("ManagerID does not exist " + dto.getManagerID(),
            // HttpStatus.BAD_REQUEST);

        } else {*/


            if(profileService.existsByID(dto.getId())){
                return mapper.entityToDto(employeeRepository.save(mapper.dtoToEntity(dto)));
            }else{
                dto.setProfile(profileService.createProfile(dto.getProfile()));
                return mapper.entityToDto(employeeRepository.save(mapper.dtoToEntity(dto)));
                
            }
            
    }
    

    public ResponseEntity<String> deleteEmployeeByID(String id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return CustomResponseEntity.deleteSuccess();
        } else {
            // Not sure what proper syntax here would be if not a Response Entity
            return CustomResponseEntity.badRequestDNE();
        }
    }

    public boolean existsByID(String id) {
        return employeeRepository.existsById(id);
    }

    public EmployeeDTO findById(String id) {
        return mapper.entityToDto(employeeRepository.findById(id).orElse(null));
    }

}
