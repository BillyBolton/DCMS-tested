package ca.me.proj.api.dtos.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationDTO {

    public String username;
    public String password;
    public AuthenticationRole role;

}
