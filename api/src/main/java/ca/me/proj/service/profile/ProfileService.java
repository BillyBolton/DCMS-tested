package ca.me.proj.service.profile;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.profile.ProfileDTO;
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

        if (Boolean.TRUE.equals(repository.existsByUsername(profileDTO.getUsername()))) {
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }

        repository.save(mapper.dtoToEntity(profileDTO));
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }

    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }


    public ProfileDTO findByUsername(String username) {
        return mapper.entityToDto(repository.findByUsername(username));
    }

    public ProfileDTO deleteUserbyUsername(String username) {
        ProfileDTO profileDTO = mapper.entityToDto(repository.findByUsername(username));
        repository.deleteById(profileDTO.getId());
        return profileDTO;
    }

    public boolean existsByID(String id) {
        return repository.existsById(id);
    }

}
