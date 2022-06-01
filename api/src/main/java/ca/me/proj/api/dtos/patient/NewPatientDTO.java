package ca.me.proj.api.dtos.patient;

import ca.me.proj.api.dtos.base.BaseDTO;
import lombok.Data;

@Data
// @EqualsAndHashCode(callSuper = true)
public class NewPatientDTO extends BaseDTO {

    private String email;
    // FKS
    private String id;

}
