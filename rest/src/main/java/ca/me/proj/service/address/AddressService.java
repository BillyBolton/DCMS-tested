package ca.me.proj.service.address;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.address.AddressDTO;
import ca.me.proj.dtos.exceptions.ResourceAlreadyExistsException;
import ca.me.proj.dtos.exceptions.ResourceNotFoundException;
import ca.me.proj.mapper.address.IAddressMapper;
import ca.me.proj.repository.address.IAddressRepository;

@Service
public class AddressService {

    @Autowired
    private IAddressMapper mapper;

    @Autowired
    private IAddressRepository repository;

    public List<AddressDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public boolean existsByID(String id) {
        return repository.existsByID(id);
    }

    public AddressDTO findByID(String id) {
        if (!existsByID(id)) {
            throw new ResourceNotFoundException("Entity with id: " + id + " not found");
        }
        return mapper.entityToDto(repository.findByID(id));
    }

    public AddressDTO findByAddress(AddressDTO dto) {
        if (!existsByAddress(dto)) {
            throw new ResourceNotFoundException("Address: " + dto + " not found");
        }
        return mapper.entityToDto(repository.findByAddress(dto.getBuildingNumber(), dto.getStreet(),
                dto.getCity(), dto.getProvince().toString(), dto.getPostalCode()));
    }

    public AddressDTO create(AddressDTO dto) {
        // dto.setId(null);

        checkExists(dto);

        // if(existsByID(dto.getId()) && !existsByAddress(dto)){
        // return findByAddress(dto);
        // }

        return save(dto);
    }

    public void deleteByID(String id) {
        repository.deleteByID(id);
    }

    private AddressDTO save(AddressDTO dto) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

    public void checkExists(AddressDTO dto) {
        if (dto.getId() != null && repository.existsByID(dto.getId())) {
            throw new ResourceAlreadyExistsException("Address ID already exists");
        }

        if (existsByAddress(dto)) {
            throw new ResourceAlreadyExistsException("Address already exists");
        }
    }

    public boolean existsByAddress(AddressDTO dto) {
        return repository.existsByAddress(dto.getBuildingNumber(), dto.getStreet(), dto.getCity(),
                dto.getProvince().toString(), dto.getPostalCode());
    }

    public AddressDTO update(AddressDTO dto) {
        if (existsByAddress(dto)) {
            AddressDTO address = findByAddress(dto);
            address.setId(dto.getId());
            dto = address;
        }

        return save(dto);
    }

}
