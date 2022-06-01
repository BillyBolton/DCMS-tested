package ca.me.proj.api.dtos.employee;

import ca.me.proj.api.dtos.branch.BranchDTO;
import ca.me.proj.api.dtos.profile.ProfileDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeDTO {

    private long SSN;
    private EmployeeRole role;
    private String type;
    private long salary;


    // FKS
    private String id;
    // private String managerID;


    // private String branchID;

    // @JsonIgnore
    private BranchDTO branch;

    private ProfileDTO profile;

}
