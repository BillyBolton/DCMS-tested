package ca.me.proj.api.dtos.procedure;

import ca.me.proj.api.dtos.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProcedureDTO extends BaseDTO {

    private String id;

    private String description;
    private Character tooth;
    private int procedureCount;

    // FKs
    private Long appointmentId;
    private String procedureCode;
    // private Long invoicedId;

}
