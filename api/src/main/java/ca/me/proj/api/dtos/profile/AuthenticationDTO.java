package ca.me.proj.api.dtos.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationDTO extends ProfileDTO {

    private String username;
    private String password;
    private AuthenticationRole role;

}
