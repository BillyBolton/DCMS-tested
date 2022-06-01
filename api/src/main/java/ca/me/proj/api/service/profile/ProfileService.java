package ca.me.proj.api.service.profile;

import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.api.dtos.exceptions.ResourceAlreadyExistsException;
import ca.me.proj.api.dtos.exceptions.ResourceNotFoundException;
import ca.me.proj.api.dtos.profile.ProfileDTO;
import ca.me.proj.api.entity.profile.ProfileEntity;
import ca.me.proj.api.repository.profile.IProfileRepository;
import ca.me.proj.api.service.address.AddressService;
import ca.me.proj.api.service.base.AbstractBaseServiceImpl;

@Service
public class ProfileService extends AbstractBaseServiceImpl<ProfileDTO, ProfileEntity, String> {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private IProfileRepository profileRepository;

    public ProfileDTO createProfile(ProfileDTO dto) {
        // TODO migrate Jake's work

        dto.setId(null);
        // One way password encryption
        dto.setPassword(authenticationService.getEncoder().encode(dto.getPassword()));

        // ID shoudl be null since this is a generated value
        if (profileRepository.existsByUsername(dto.getUsername())) {
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

    public boolean existsByUsername(String username) {
        return profileRepository.existsByUsername(username);
    }

    public ProfileDTO findByUsername(String username) {
        if (!existsByUsername(username)) {
            throw new ResourceNotFoundException("Entity with username: " + username + " not found");
        }
        return mapper.entityToDto(profileRepository.findByUsername(username));
    }

    public void deleteByUsername(String username) {

        if (!profileRepository.existsByUsername(username)) {
            throw new ResourceNotFoundException(
                    "Profile with username: " + username + " does not exist");
        }

        profileRepository.deleteById((profileRepository.findByUsername(username)).getId());
    }


    @Override
    public ProfileDTO update(ProfileDTO dto) {

        if (!repository.existsById(dto.getId())) {
            throw new ResourceNotFoundException(
                    "Profile with id: " + dto.getId() + " does not exist");
        }
        if (addressService.existsByAddress(dto.getAddress())) {
            dto.setAddress(addressService.findByAddress(dto.getAddress()));
        } else {
            dto.setAddress(addressService.update(dto.getAddress()));
        }


        dto.setDOB(dto.getDOB().plusDays(1L));

        // authenticate(mapper.profileDtoToAuthenticationDto(dto));

        return save(dto);
    }



}
