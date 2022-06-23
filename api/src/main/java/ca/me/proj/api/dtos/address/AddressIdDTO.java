package ca.me.proj.api.dtos.address;

import ca.me.proj.api.constants.province.Province;
import lombok.Data;

// This DTO is no longer being used. Keeping it here as a reference for composite keys.
@Data
public class AddressIdDTO {
    public String buildingNumber;
    public String street;
    public String city;
    public Province province;
    public String postalCode;
}
