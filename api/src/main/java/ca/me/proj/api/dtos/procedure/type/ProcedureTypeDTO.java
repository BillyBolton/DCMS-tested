package ca.me.proj.api.dtos.procedure.type;

import ca.me.proj.api.dtos.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProcedureTypeDTO extends BaseDTO {

    private String id;
    private String type;

}
