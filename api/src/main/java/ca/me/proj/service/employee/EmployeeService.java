package ca.me.proj.service.employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.employee.EmployeeDTO;
import ca.me.proj.mapper.employee.IEmployeeMapper;
import ca.me.proj.repository.branch.IBranchRepository;
import ca.me.proj.repository.employee.IEmployeeRepository;
import ca.me.proj.repository.profile.IProfileRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private IEmployeeMapper mapper;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IProfileRepository profileRepository;

    @Autowired
    private IBranchRepository branchRepository;

    public List<EmployeeDTO> findAll() {
        return mapper.entityToDto(employeeRepository.findAll());
    }

    public ResponseEntity<String> createEmployee(EmployeeDTO employeeDTO){
        
        //If ID does not exist in Profile repo
        if(!profileRepository.existsById(employeeDTO.getId())){
            return new ResponseEntity<String>(
                "ID does not exist", 
                HttpStatus.BAD_REQUEST);
        }

        //If Employee Role is incorrectly formated
        else if (!employeeDTO.getRole().equals("MANAGER")
                 && !employeeDTO.getRole().equals("RECEPTIONIST")    
                 && !employeeDTO.getRole().equals("DENTIST")
                 && !employeeDTO.getRole().equals("HYGIENIST")   
                )     
            {
            return new ResponseEntity<String>(
                "Invalid Employee Role: " + employeeDTO.getRole(), 
                 HttpStatus.BAD_REQUEST);
                
            }

        //If Employee type is incorrectly formated
        else if(!employeeDTO.getType().equals("FT")
                && !employeeDTO.getType().equals("PT")
                )
            {
            return new ResponseEntity<String>(
                "Invalid Employee Type: " + employeeDTO.getType(), 
                HttpStatus.BAD_REQUEST);
            }

        //If Employee Salary is less than or equal to 0
        else if(employeeDTO.getSalary() <= 0 ){
            return new ResponseEntity<String>(
                "Salary must be > 0: " + employeeDTO.getSalary(),
                HttpStatus.BAD_REQUEST);
        }

        //If Branch does not exist
        else if(!branchRepository.existsById(employeeDTO.getBranchID())){
            return new ResponseEntity<String>(
                "Branch ID does not exist " + employeeDTO.getBranchID(),
                HttpStatus.BAD_REQUEST);

        }
        //If ManagerID does not exists
        else if(employeeDTO.getManagerID()!= null && !employeeRepository.existsById(employeeDTO.getManagerID())){
            return new ResponseEntity<String>(
                "ManagerID does not exist " + employeeDTO.getManagerID(),
                HttpStatus.BAD_REQUEST);

        }
        else{
            employeeRepository.save(mapper.dtoToEntity(employeeDTO));
            return new ResponseEntity<String>("Success",HttpStatus.ACCEPTED);
        }

    }

    public ResponseEntity<String> deleteEmployeeByID(String id){
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return new ResponseEntity<String>("Success: Deleted ID: " + id,HttpStatus.ACCEPTED);
        }
        else{
            //Not sure what proper syntax here would be if not a Response Entity
            return new ResponseEntity<String>(
            "ID does not exist", 
            HttpStatus.BAD_REQUEST);
        }
    
    }
}
