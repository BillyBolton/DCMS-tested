package ca.me.proj.entity.address;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import ca.me.proj.constants.province.Province;
import lombok.Data;

@Embeddable
@Data
public class AddressId implements Serializable {

    @Column(name = "building_number")
    public String buildingNumber;

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
