package ca.me.proj.dtos.treatment;

import lombok.Data;

@Data
public class TreatmentDTO {

    private Long id;

    private String medication;

    private String procedureId;

    // private Character teeth;

    private String symtoms;

    private String comments;

}
