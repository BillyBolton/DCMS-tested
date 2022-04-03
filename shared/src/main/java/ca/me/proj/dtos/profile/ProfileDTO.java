
package ca.me.proj.dtos.profile;

import java.util.Date;
import ca.me.proj.dtos.address.AddressDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProfileDTO {
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date DOB;
    private AddressDTO address;

}


