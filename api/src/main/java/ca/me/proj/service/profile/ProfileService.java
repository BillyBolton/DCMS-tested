package ca.me.proj.service.profile;

import java.util.List;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.profile.ProfileDTO;
import ca.me.proj.exceptions.ResourceAlreadyExistsException;
import ca.me.proj.exceptions.ResourceNotFoundException;
import ca.me.proj.repository.profile.IProfileRepository;
import ca.me.proj.service.address.AddressService;

@Service
public class ProfileService extends AuthenticationService {

    @Autowired
    private AddressService addressService;

    @Autowired
    private IProfileRepository repository;

    public List<ProfileDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public ProfileDTO createProfile(ProfileDTO dto) {
        // TODO migrate Jake's work

        dto.setId(null);
        // One way password encryption
        dto.setPassword(encoder.encode(dto.getPassword()));

        // ID shoudl be null since this is a generated value
        if (repository.existsByUsername(dto.getUsername())) {
            throw new ResourceAlreadyExistsException("Username already exists");
        }
        dto.setDOB(dto.getDOB().plusDays(1));

        try {
            addressService.checkExists(dto.getAddress());
            dto.setAddress(addressService.create(dto.getAddress()));
        } catch (ConstraintViolationException e) {
            dto.setAddress(addressService.findByAddress(dto.getAddress()));
        } catch (ResourceAlreadyExistsException e) {
            dto.setAddress(addressService.findByAddress(dto.getAddress()));
        }

        return save(dto);
    }

    public ProfileDTO save(ProfileDTO dto) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    public ProfileDTO findByUsername(String username) {
        if (!existsByUsername(username)) {
            throw new ResourceNotFoundException("Entity with username: " + username + " not found");
        }
        return mapper.entityToDto(repository.findByUsername(username));
    }

    public void deleteUserbyUsername(String username) {

        if (!repository.existsByUsername(username)) {
            throw new ResourceNotFoundException(
                    "Profile with username: " + username + " does not exist");
        }

        repository.deleteByID((repository.findByUsername(username)).getId());
    }

    public boolean existsByID(String id) {
        return repository.existsByID(id);
    }

    public ProfileDTO update(ProfileDTO dto) {

        if (!repository.existsByID(dto.getId())) {
            throw new ResourceNotFoundException(
                    "Profile with id: " + dto.getId() + " does not exist");
        }

        dto.setAddress(addressService.update(dto.getAddress()));
        dto.setDOB(dto.getDOB().plusDays(1L));

        // authenticate(mapper.profileDtoToAuthenticationDto(dto));

        return save(dto);
    }



}
