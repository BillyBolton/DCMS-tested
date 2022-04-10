package ca.me.proj.mapper.branch;



import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.dtos.branch.BranchDTO;
import ca.me.proj.entity.branch.BranchEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IBranchMapper extends IBaseMapper<BranchDTO, BranchEntity> {

    // BranchDTO entityToDto(BranchEntity entity);

    // BranchEntity dtoToEntity(BranchDTO dto);

}
