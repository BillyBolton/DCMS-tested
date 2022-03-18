package ca.me.proj.entity.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
    
 

    @NotNull
    @Column(name = "SSN")
    private long SSN;

    @NotNull
    @Column(name = "role")
    private String role;
    
    @NotNull
    @Column(name = "type")
    private String type;

    @NotNull
    @Column(name = "salary")
    private long salary;
   

    //FKS
    @Id
    @NotNull
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "managerID")
    private String managerID;

    @NotNull
    @Column(name = "branchID")
    private String branchID;

}
