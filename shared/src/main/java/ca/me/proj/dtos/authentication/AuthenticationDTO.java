package ca.me.proj.dtos.authentication;

import ca.me.proj.rest.components.dtos.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("unused")
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthenticationDTO extends BaseDTO {

    private String username;
    private String password;

}
