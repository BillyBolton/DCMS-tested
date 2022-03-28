package ca.me.proj.mapper.address;

import java.util.List;

import org.mapstruct.Mapper;
import ca.me.proj.dtos.address.AddressDTO;
import ca.me.proj.entity.address.AddressEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper
public interface IAddressMapper extends IBaseMapper<AddressDTO, AddressEntity> {

    AddressDTO entityToDto(AddressEntity entity);

    AddressEntity dtoToEntity(AddressDTO dto);

    List<AddressEntity> dtoToEntity(Iterable<AddressDTO> dtos);

    List<AddressDTO> entityToDto(Iterable<AddressEntity> entities);

}
