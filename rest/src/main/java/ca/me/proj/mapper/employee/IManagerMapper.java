package ca.me.proj.mapper.employee;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.dtos.employee.ManagerDTO;
import ca.me.proj.entity.employee.ManagerEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IManagerMapper extends IBaseMapper<ManagerDTO, ManagerEntity> {

}
