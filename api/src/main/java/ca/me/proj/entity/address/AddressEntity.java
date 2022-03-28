package ca.me.proj.entity.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ca.me.proj.constants.province.Province;
import lombok.Data;

@Data
@Entity
@Table(name = "ADDRESS")
public class AddressEntity {
    
    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
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

}
