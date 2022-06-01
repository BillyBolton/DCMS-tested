package ca.me.proj.api.dtos.procedure.type;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProcedureTypeDTO {

    private String id;
    private String type;

}
