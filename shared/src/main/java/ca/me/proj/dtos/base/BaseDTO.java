package ca.me.proj.dtos.base;

import java.io.Serializable;
import lombok.Data;

@Data
public class BaseDTO implements IBaseDTO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6672771950395342891L;

	private Long auth_id;

}
