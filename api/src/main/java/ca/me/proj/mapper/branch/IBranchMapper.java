package ca.me.proj.mapper.branch;



import org.mapstruct.Mapper;
import ca.me.proj.dtos.branch.BranchDTO;
import ca.me.proj.entity.branch.BranchEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper
public interface IBranchMapper extends IBaseMapper<BranchDTO, BranchEntity> {

    // BranchDTO entityToDto(BranchEntity entity);

    // BranchEntity dtoToEntity(BranchDTO dto);

    // List<BranchEntity> dtoToEntity(Iterable<BranchDTO> dtos);

    // List<BranchDTO> entityToDto(Iterable<BranchEntity> entities);
}
