package ca.me.proj.service.profile;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.profile.ProfileDTO;
import ca.me.proj.entity.response.CustomResponseEntity;
import ca.me.proj.repository.profile.IProfileRepository;

@Service
public class ProfileService extends AuthenticationService {

    @Autowired
    private IProfileRepository repository;

    public List<ProfileDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public ResponseEntity<String> createProfile(ProfileDTO profileDTO) {

        // One way password encryption
        profileDTO.setPassword(encoder.encode(profileDTO.getPassword()));

        if (repository.existsByUsername(profileDTO.getUsername())) {
            return CustomResponseEntity.badRequestDNE();
        }

        repository.save(mapper.dtoToEntity(profileDTO));
        return CustomResponseEntity.saveSuccess();
    }

    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    // TODO: Response Entity
    public ProfileDTO findByUsername(String username) {
        return mapper.entityToDto(repository.findByUsername(username));
    }

    // TODO: Repsponse Entity
    public ProfileDTO deleteUserbyUsername(String username) {
        ProfileDTO profileDTO = mapper.entityToDto(repository.findByUsername(username));
        repository.deleteById(profileDTO.getId());
        return profileDTO;
    }

    public boolean existsByID(String id) {
        return repository.existsById(id);
    }

}
