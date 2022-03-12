package ca.me.proj.mapper.procedure;

import java.util.List;
import org.mapstruct.Mapper;
import ca.me.proj.dtos.procedure.ProcedureDTO;
import ca.me.proj.entity.procedure.ProcedureEntity;

@Mapper
public interface IProcedureMapper {

    ProcedureDTO entityToDto(ProcedureEntity entity);

    ProcedureEntity dtoToEntity(ProcedureDTO dto);

    List<ProcedureEntity> dtoToEntity(Iterable<ProcedureDTO> dtos);

    List<ProcedureDTO> entityToDto(Iterable<ProcedureEntity> entities);

}
