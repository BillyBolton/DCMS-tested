package ca.me.proj.api.dtos.employee;

import ca.me.proj.api.dtos.base.BaseDTO;
import ca.me.proj.api.dtos.profile.ProfileDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ManagerDTO extends BaseDTO {

    private ProfileDTO profile;

}
