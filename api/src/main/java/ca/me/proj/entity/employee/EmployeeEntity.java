package ca.me.proj.entity.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import ca.me.proj.entity.base.AbstractStringEntity;
import ca.me.proj.entity.profile.ProfileEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity extends AbstractStringEntity {



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


    // FKS
    // @Id
    // @NotNull
    // @Column(name = "id")
    // private String id;

    @NotNull
    @Column(name = "manager_id")
    private String managerID;

    @NotNull
    @Column(name = "branch_id")
    private String branchID;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private ProfileEntity profile;

}
