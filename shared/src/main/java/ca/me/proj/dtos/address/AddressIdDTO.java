package ca.me.proj.dtos.address;

import ca.me.proj.constants.province.Province;
import lombok.Data;

@Data
public class AddressIdDTO {
    public String buildingNumber;
    public String street;
    public String city;
    public Province province;
    public String postalCode;
}
