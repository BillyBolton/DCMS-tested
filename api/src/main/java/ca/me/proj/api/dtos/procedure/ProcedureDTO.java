package ca.me.proj.api.dtos.procedure;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProcedureDTO {

    private String id;

    private String description;
    private Character tooth;
    private int procedureCount;

    // FKs
    private Long appointmentId;
    private String procedureCode;
    // private Long invoicedId;

}
