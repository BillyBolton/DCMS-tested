package ca.me.proj.api.mapper.procedure.type;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.api.dtos.procedure.type.ProcedureTypeDTO;
import ca.me.proj.api.entity.procedure.type.ProcedureTypeEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProcedureTypeMapper extends IBaseMapper<ProcedureTypeDTO, ProcedureTypeEntity> {

}
