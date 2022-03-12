package ca.me.proj.dtos.procedure;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProcedureDTO {

    private Long id;

    private String description;
    private Character tooth;
    private int procedureCount;

    // FKs
    private Long appointmentId;
    private Long procedureCode;
    private Long invoicedId;

}
