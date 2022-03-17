package ca.me.proj.mapper.address;

import org.mapstruct.Mapper;
import ca.me.proj.dtos.address.AddressIdDTO;
import ca.me.proj.entity.address.AddressId;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper
public interface IAddressIdMapper extends IBaseMapper<AddressIdDTO, AddressId> {

}
