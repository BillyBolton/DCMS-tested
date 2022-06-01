package ca.me.proj.api.mapper.procedure;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.api.dtos.procedure.ProcedureDTO;
import ca.me.proj.api.entity.procedure.ProcedureEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProcedureMapper extends IBaseMapper<ProcedureDTO, ProcedureEntity> {

    ProcedureDTO entityToDto(ProcedureEntity entity);

    ProcedureEntity dtoToEntity(ProcedureDTO dto);

    List<ProcedureEntity> dtoToEntity(Iterable<ProcedureDTO> dtos);

    List<ProcedureDTO> entityToDto(Iterable<ProcedureEntity> entities);

}
