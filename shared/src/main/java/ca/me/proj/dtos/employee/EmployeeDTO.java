package ca.me.proj.dtos.employee;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeDTO {
  
    private long SSN;
    private String role;
    private String type;
    private long salary;
   

    //FKS
    private String id;
    private String managerID;
    private String branchID;

}
