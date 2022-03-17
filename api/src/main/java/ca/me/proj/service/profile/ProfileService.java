package ca.me.proj.service.profile;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.profile.ProfileDTO;
import ca.me.proj.entity.profile.ProfileEntity;
import ca.me.proj.mapper.profile.IProfileMapper;
import ca.me.proj.repository.profile.IProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private IProfileMapper mapper;

    @Autowired
    private IProfileRepository repository;

    public List<ProfileDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public void createUser(String firstname, String middlename, String lastname, Date dob, String username, String password){
        ProfileEntity entity = new ProfileEntity(firstname,middlename,lastname,dob);
        repository.save(entity);
    }
    
}
