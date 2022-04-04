package ca.me.proj.mapper.procedure.type;

import org.mapstruct.Mapper;
import ca.me.proj.dtos.procedure.type.ProcedureTypeDTO;
import ca.me.proj.entity.procedure.type.ProcedureTypeEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper
public interface IProcedureTypeMapper extends IBaseMapper<ProcedureTypeDTO, ProcedureTypeEntity> {

}
