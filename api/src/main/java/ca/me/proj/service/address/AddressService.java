package ca.me.proj.service.address;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.address.AddressDTO;
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

}
