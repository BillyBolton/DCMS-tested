package ca.me.proj.service.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.address.AddressDTO;
import ca.me.proj.entity.response.CustomResponseEntity;
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
        return repository.existsById(id);
    }

    public AddressDTO findByID(String id){
        return mapper.entityToDto(repository.findByID(id));  
    }

    public ResponseEntity<String> createAddress(AddressDTO dto) {
        dto.setId(null);
        repository.save(mapper.dtoToEntity(dto));
        return CustomResponseEntity.saveSuccess();
    }

    public ResponseEntity<String> deleteAddressbyId(String id) {
        repository.deleteById(id);
        return CustomResponseEntity.deleteSuccess();
    }

}
