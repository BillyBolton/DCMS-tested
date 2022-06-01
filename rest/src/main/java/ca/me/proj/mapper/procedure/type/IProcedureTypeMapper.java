package ca.me.proj.mapper.procedure.type;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.dtos.procedure.type.ProcedureTypeDTO;
import ca.me.proj.entity.procedure.type.ProcedureTypeEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProcedureTypeMapper extends IBaseMapper<ProcedureTypeDTO, ProcedureTypeEntity> {

}
