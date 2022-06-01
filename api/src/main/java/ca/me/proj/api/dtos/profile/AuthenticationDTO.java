package ca.me.proj.api.dtos.profile;

import lombok.Data;

@Data
public class AuthenticationDTO {

    public String username;
    public String password;
    public AuthenticationRole role;

}
