package ca.me.proj.service.address;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.address.AddressDTO;
import ca.me.proj.exceptions.ResourceNotFoundException;
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
        if (!repository.existsByID(id)) {
            throw new ResourceNotFoundException("Address ID does not exist");
        }
        return mapper.entityToDto(repository.findByID(id));
    }

    public AddressDTO create(AddressDTO dto) {
        dto.setId(null);
        return save(dto);
    }

    public void deleteByID(String id) {
        repository.deleteByID(id);
    }

    public AddressDTO save(AddressDTO dto) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

}
