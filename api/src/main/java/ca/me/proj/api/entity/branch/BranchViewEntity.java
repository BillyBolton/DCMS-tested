package ca.me.proj.api.entity.branch;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import ca.me.proj.api.entity.address.AddressEntity;
import ca.me.proj.api.entity.base.AbstractStringEntity;
import ca.me.proj.api.entity.employee.ManagerEntity;
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


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private ManagerEntity manager;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;
}
