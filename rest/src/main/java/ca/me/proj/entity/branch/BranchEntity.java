package ca.me.proj.entity.branch;


import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import ca.me.proj.entity.address.AddressEntity;
import ca.me.proj.entity.base.AbstractStringEntity;
import ca.me.proj.entity.employee.EmployeeEntity;
import ca.me.proj.entity.procedure.type.ProcedureTypeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "BRANCH")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class BranchEntity extends AbstractStringEntity {

    // FK
    // @Column(name = "manager_id")
    // private String manager_id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private EmployeeEntity manager;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BRANCH_PROCEDURES", joinColumns = @JoinColumn(name = "branch_id"),
            inverseJoinColumns = @JoinColumn(name = "procedure_id"))
    private List<ProcedureTypeEntity> procedures;

}
