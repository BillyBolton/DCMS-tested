package ca.me.proj.api.mapper.employee;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.api.dtos.employee.ManagerDTO;
import ca.me.proj.api.entity.employee.ManagerEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IManagerMapper extends IBaseMapper<ManagerDTO, ManagerEntity> {

}
