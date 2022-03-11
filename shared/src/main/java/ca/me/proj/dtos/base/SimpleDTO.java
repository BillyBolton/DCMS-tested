package ca.me.proj.dtos.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleDTO extends BaseDTO {

    /**
     * 
     */
    private static final long serialVersionUID = -6672771950395342891L;
    private Long entityId;

}
