package ca.me.proj.api.controller.employee;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.api.controller.base.AbstractCrudController;
import ca.me.proj.api.dtos.employee.EmployeeDTO;
import ca.me.proj.api.dtos.employee.NewEmployeeDTO;
import ca.me.proj.api.entity.employee.EmployeeEntity;
import ca.me.proj.api.service.employee.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController
        extends AbstractCrudController<EmployeeDTO, EmployeeEntity, String> {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/dentist/find/ByBranchId")
    public List<EmployeeDTO> findDentistByBranchId(String branchId) {
        return employeeService.findDentistByBranchId(branchId);
    }

    @PostMapping("/create/lite")
    public NewEmployeeDTO create(@RequestBody NewEmployeeDTO dto) {
        return employeeService.create(dto);
    }


}
