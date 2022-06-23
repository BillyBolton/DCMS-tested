package ca.me.proj.api.dtos.treatment;

import ca.me.proj.api.dtos.base.BaseDTO;
import lombok.Data;

@Data
public class TreatmentDTO extends BaseDTO {

    private Long id;

    private String medication;

    private String procedureId;

    // private Character teeth;

    private String symtoms;

    private String comments;

}
