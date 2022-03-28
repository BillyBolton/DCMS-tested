package ca.me.proj.dtos.address;

import ca.me.proj.constants.province.Province;
import lombok.Data;


@Data
public class AddressDTO {

    private String id;
    private Long buildingNumber;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

}
