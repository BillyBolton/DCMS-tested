package ca.me.proj.mapper.employee;

import java.util.List;
import org.mapstruct.Mapper;
import ca.me.proj.dtos.employee.EmployeeDTO;
import ca.me.proj.entity.employee.EmployeeEntity;

@Mapper
public interface IEmployeeMapper {
    
    EmployeeDTO entityToDto(EmployeeEntity entity);

    EmployeeEntity dtoToEntity(EmployeeDTO dto);

    List<EmployeeEntity> dtoToEntity(Iterable<EmployeeDTO> dtos);

    List<EmployeeDTO> entityToDto(Iterable<EmployeeEntity> entities);
}
