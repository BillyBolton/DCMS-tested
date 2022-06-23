package ca.me.proj.api.mapper.address;

import org.mapstruct.Mapper;
import ca.me.proj.api.dtos.address.AddressDTO;
import ca.me.proj.api.entity.address.AddressEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;

@Mapper
public interface IAddressMapper extends IBaseMapper<AddressDTO, AddressEntity> {

}
