package ca.me.proj.entity.branch;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import ca.me.proj.entity.address.NestedAddressEntity;
import ca.me.proj.entity.base.AbstractStringEntity;
import ca.me.proj.entity.employee.EmployeeEntity;
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

    @OneToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private EmployeeEntity manager;


    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private NestedAddressEntity address;
}
