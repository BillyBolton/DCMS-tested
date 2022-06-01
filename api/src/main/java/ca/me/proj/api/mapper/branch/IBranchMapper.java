package ca.me.proj.api.mapper.branch;



import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.api.dtos.branch.BranchDTO;
import ca.me.proj.api.entity.branch.BranchEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IBranchMapper extends IBaseMapper<BranchDTO, BranchEntity> {

    // BranchDTO entityToDto(BranchEntity entity);

    // BranchEntity dtoToEntity(BranchDTO dto);

}
