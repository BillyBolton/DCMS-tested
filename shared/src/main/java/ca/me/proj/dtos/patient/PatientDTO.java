package ca.me.proj.dtos.patient;


import ca.me.proj.dtos.base.BaseStringDTO;
import ca.me.proj.dtos.profile.ProfileDTO;
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
