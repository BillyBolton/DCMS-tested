package ca.me.proj.mapper.procedure;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.dtos.procedure.ProcedureDTO;
import ca.me.proj.entity.procedure.ProcedureEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProcedureMapper extends IBaseMapper<ProcedureDTO, ProcedureEntity> {

    ProcedureDTO entityToDto(ProcedureEntity entity);

    ProcedureEntity dtoToEntity(ProcedureDTO dto);

    List<ProcedureEntity> dtoToEntity(Iterable<ProcedureDTO> dtos);

    List<ProcedureDTO> entityToDto(Iterable<ProcedureEntity> entities);

}
