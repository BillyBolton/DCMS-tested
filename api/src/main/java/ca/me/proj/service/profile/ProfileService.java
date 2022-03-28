package ca.me.proj.service.profile;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public ResponseEntity<String> createProfile(ProfileDTO dto) {
        dto.setId(null);
        // One way password encryption
        dto.setPassword(encoder.encode(dto.getPassword()));

        // ID shoudl be null since this is a generated value
        if (repository.existsByUsername(dto.getUsername())) {
            return new ResponseEntity<>("BAD REQUEST - Username already taken ",
                    HttpStatus.BAD_REQUEST);
        }


        repository.save(mapper.dtoToEntity(dto));
        return CustomResponseEntity.saveSuccess();
    }

    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    public ProfileDTO findByUsername(String username) {
        return mapper.entityToDto(repository.findByUsername(username));
    }

    public ResponseEntity<String> deleteUserbyUsername(String username) {
        if (!repository.existsByUsername(username)) {
            return CustomResponseEntity.badRequestDNE();
        }

        repository.deleteById(mapper.entityToDto(repository.findByUsername(username)).getId());
        return CustomResponseEntity.deleteSuccess();
    }

    public boolean existsByID(String id) {
        return repository.existsById(id);
    }

}
