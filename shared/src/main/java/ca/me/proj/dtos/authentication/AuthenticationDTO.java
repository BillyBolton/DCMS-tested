package ca.me.proj.dtos.authentication;

import ca.me.proj.dtos.base.SimpleDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("unused")
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthenticationDTO extends SimpleDTO {

    private String username;
    private String password;

}
