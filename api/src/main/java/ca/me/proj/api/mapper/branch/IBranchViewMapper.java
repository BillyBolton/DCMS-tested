package ca.me.proj.api.mapper.branch;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.api.dtos.branch.BranchViewDTO;
import ca.me.proj.api.entity.branch.BranchViewEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;



@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IBranchViewMapper extends IBaseMapper<BranchViewDTO, BranchViewEntity> {


    // BranchViewDTO entityToDto(BranchViewEntity entity);

    // BranchViewEntity dtoToEntity(BranchViewDTO dto);

}
