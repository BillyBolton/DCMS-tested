package ca.me.proj.dtos.employee;

import ca.me.proj.dtos.profile.ProfileDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ManagerDTO {

    private ProfileDTO profile;

}
