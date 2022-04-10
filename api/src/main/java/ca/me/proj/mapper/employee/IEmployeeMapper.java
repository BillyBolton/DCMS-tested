package ca.me.proj.mapper.employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.dtos.employee.EmployeeDTO;
import ca.me.proj.dtos.employee.NewEmployeeDTO;
import ca.me.proj.entity.employee.EmployeeEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IEmployeeMapper extends IBaseMapper<EmployeeDTO, EmployeeEntity> {

    // EmployeeDTO entityToDto(EmployeeEntity entity);

    // EmployeeEntity dtoToEntity(EmployeeDTO dto);

    @Mapping(target = "branch.id", source = "branchID")
    EmployeeDTO liteToDto(NewEmployeeDTO dto);

    @Mapping(source = "branch.id", target = "branchID")
    NewEmployeeDTO dtoToLite(EmployeeDTO dto);

}
