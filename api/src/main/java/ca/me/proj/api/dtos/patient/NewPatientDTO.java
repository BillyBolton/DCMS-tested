package ca.me.proj.api.dtos.patient;

import lombok.Data;

@Data
// @EqualsAndHashCode(callSuper = true)
public class NewPatientDTO {

    private String email;
    // FKS
    private String id;

}
