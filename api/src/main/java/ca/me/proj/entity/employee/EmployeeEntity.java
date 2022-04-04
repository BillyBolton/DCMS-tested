package ca.me.proj.entity.employee;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import ca.me.proj.dtos.employee.EmployeeRole;
import ca.me.proj.entity.base.AbstractStringEntity;
import ca.me.proj.entity.branch.BranchEntity;
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
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private EmployeeRole role;

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

    // @NotNull
    // @Column(name = "manager_id")
    // private String managerID;

    // @NotNull
    // @Column(name = "branch_id")
    // private String branchID;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private BranchEntity branch;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private ProfileEntity profile;
}
