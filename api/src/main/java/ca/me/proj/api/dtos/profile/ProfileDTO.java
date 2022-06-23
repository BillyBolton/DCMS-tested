
package ca.me.proj.api.dtos.profile;

import java.time.LocalDate;
import ca.me.proj.api.dtos.address.AddressDTO;
import ca.me.proj.api.dtos.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProfileDTO extends BaseDTO {

    private String id;
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate DOB;
    private AddressDTO address;

}


