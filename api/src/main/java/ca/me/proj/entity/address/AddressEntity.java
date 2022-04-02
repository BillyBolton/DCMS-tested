package ca.me.proj.entity.address;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import ca.me.proj.constants.province.Province;
import ca.me.proj.entity.base.AbstractStringEntity;
import ca.me.proj.entity.branch.BranchEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ADDRESS")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class AddressEntity extends AbstractStringEntity {

    // @Id
    // @NotNull
    // @Column(name = "id")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private String id;

    @Column(name = "building_number")
    public Long buildingNumber;

    @Column(name = "street")
    public String street;

    @Column(name = "city")
    public String city;

    @Column(name = "province")
    @Enumerated(EnumType.STRING)
    public Province province;

    @Column(name = "postal_code")
    public String postalCode;


    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BranchEntity branch;
}
