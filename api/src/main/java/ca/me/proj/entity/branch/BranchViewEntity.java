package ca.me.proj.entity.branch;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import ca.me.proj.entity.address.AddressEntity;
import ca.me.proj.entity.base.AbstractStringEntity;
import ca.me.proj.entity.employee.ManagerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "BRANCH")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class BranchViewEntity extends AbstractStringEntity {

    // FK
    // @Column(name = "manager_id")
    // private String manager_id;

    // @OneToMany(mappedBy = "branch")
    // List<NestedEmployeeEntity> employees;


    @OneToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private ManagerEntity manager;


    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;
}
