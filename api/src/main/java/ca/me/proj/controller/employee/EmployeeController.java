package ca.me.proj.controller.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.employee.EmployeeDTO;
import ca.me.proj.service.employee.EmployeeService;
import io.micrometer.core.ipc.http.HttpSender.Response;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findAll")
    public List<EmployeeDTO> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        ResponseEntity<String> response = employeeService.createEmployee(employeeDTO);
        return response;
    }

    @DeleteMapping("/deleteByID")
    public ResponseEntity<String> deleteEmployeeByID(@RequestParam String id){
        return employeeService.deleteEmployeeByID(id);
    }
}
