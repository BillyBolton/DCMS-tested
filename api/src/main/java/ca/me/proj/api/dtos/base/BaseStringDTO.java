package ca.me.proj.api.dtos.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseStringDTO extends BaseDTO {

    private String id;

}
