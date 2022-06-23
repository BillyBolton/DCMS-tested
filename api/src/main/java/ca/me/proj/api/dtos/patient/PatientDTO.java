package ca.me.proj.api.dtos.patient;


import ca.me.proj.api.dtos.base.BaseStringDTO;
import ca.me.proj.api.dtos.profile.ProfileDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PatientDTO extends BaseStringDTO {

    private String email;
    // FKS
    private String id;

    private ProfileDTO profile;
}
