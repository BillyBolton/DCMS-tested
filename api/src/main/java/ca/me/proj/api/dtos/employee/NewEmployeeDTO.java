package ca.me.proj.api.dtos.employee;

import ca.me.proj.api.dtos.profile.ProfileDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewEmployeeDTO {

    private long SSN;
    private EmployeeRole role;
    private EmployeeType type;
    private long salary;


    // FKS
    private String id;
    // private String managerID;

    private String branchID;

    private ProfileDTO profile;

}
