package ca.me.proj.mapper.branch;



import java.util.List;
import org.mapstruct.Mapper;

import ca.me.proj.dtos.branch.BranchDTO;
import ca.me.proj.entity.branch.BranchEntity;

@Mapper
public interface IBranchMapper {
    BranchDTO entityToDto(BranchEntity entity);

    BranchEntity dtoToEntity(BranchDTO dto);

    List<BranchEntity> dtoToEntity(Iterable<BranchDTO> dtos);

    List<BranchDTO> entityToDto(Iterable<BranchEntity> entities);
}
