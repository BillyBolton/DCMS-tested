package ca.me.proj.mapper.address;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.dtos.address.AddressDTO;
import ca.me.proj.entity.address.AddressEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAddressMapper extends IBaseMapper<AddressDTO, AddressEntity> {

}
