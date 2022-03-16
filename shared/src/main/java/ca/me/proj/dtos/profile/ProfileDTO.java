
package ca.me.proj.dtos.profile;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class ProfileDTO {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date DOB;
 
}
    





