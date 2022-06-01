package ca.me.proj.api.entity.address;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import ca.me.proj.api.constants.province.Province;
import ca.me.proj.api.entity.base.AbstractStringEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "ADDRESS")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class AddressEntity extends AbstractStringEntity {

    private static final long servialVersionUID = 539485762983745923L;

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


    // @OneToOne(mappedBy = "address", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // private BranchEntity branch;
}
