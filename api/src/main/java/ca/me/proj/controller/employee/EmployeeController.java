package ca.me.proj.controller.employee;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.employee.EmployeeDTO;
import ca.me.proj.service.employee.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/findAll")
    public List<EmployeeDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/dentist/findByBranchId")
    public List<EmployeeDTO> findDentistByBranchId(String branchId) {
        return service.findDentistByBranchId(branchId);
    }

    @PostMapping("/create")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO dto) {
        return service.createEmployee(dto);
    }

    @DeleteMapping("/deleteByID")
    public ResponseEntity<String> deleteEmployeeByID(@RequestParam String id) {
        return service.deleteEmployeeByID(id);
    }

    @GetMapping("/existsByID")
    public boolean existsByID(@RequestParam String id) {
        return service.existsByID(id);
    }

    @GetMapping("/findById")
    public EmployeeDTO findByID(@RequestParam String id) {
        return service.findById(id);
    }
}
