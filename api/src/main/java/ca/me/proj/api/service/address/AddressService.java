package ca.me.proj.api.service.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.api.dtos.address.AddressDTO;
import ca.me.proj.api.dtos.exceptions.ResourceAlreadyExistsException;
import ca.me.proj.api.dtos.exceptions.ResourceNotFoundException;
import ca.me.proj.api.entity.address.AddressEntity;
import ca.me.proj.api.repository.address.IAddressRepository;
import ca.me.proj.api.service.base.AbstractBaseServiceImpl;

@Service
public class AddressService extends AbstractBaseServiceImpl<AddressDTO, AddressEntity, String> {

    @Autowired
    private IAddressRepository addressRepository;

    public AddressDTO findByAddress(AddressDTO dto) {
        if (!existsByAddress(dto)) {
            throw new ResourceNotFoundException("Address: " + dto + " not found");
        }
        return mapper.entityToDto(
                addressRepository.findByBuildingNumberAndStreetAndCityAndProvinceAndPostalCode(
                        dto.getBuildingNumber(), dto.getStreet(), dto.getCity(), dto.getProvince(),
                        dto.getPostalCode()));
    }

    public AddressDTO create(AddressDTO dto) {
        checkExists(dto);
        return save(dto);
    }

    public void checkExists(AddressDTO dto) {
        if (dto.getId() != null && repository.existsById(dto.getId())) {
            throw new ResourceAlreadyExistsException("Address ID already exists");
        }

        if (existsByAddress(dto)) {
            throw new ResourceAlreadyExistsException("Address already exists");
        }
    }

    public boolean existsByAddress(AddressDTO dto) {
        return addressRepository.existsByBuildingNumberAndStreetAndCityAndProvinceAndPostalCode(
                dto.getBuildingNumber(), dto.getStreet(), dto.getCity(), dto.getProvince(),
                dto.getPostalCode());
    }


}
