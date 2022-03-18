package ca.me.proj.dtos.patient;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PatientDTO {

    private String email;
    //FKS
    private String id;
}
