package ca.me.proj.service.patient;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.patient.PatientDTO;
import ca.me.proj.exceptions.ResourceNotFoundException;
import ca.me.proj.mapper.patient.IPatientMapper;
import ca.me.proj.repository.patient.IPatientRepository;
import ca.me.proj.service.profile.ProfileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientService {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private IPatientMapper mapper;

    @Autowired
    private IPatientRepository repository;

    public List<PatientDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public PatientDTO createPatient(PatientDTO dto) {


        if (profileService.existsByUsername(dto.getProfile().getUsername())) {
            return save(dto);
        }

        if (profileService.existsByID(dto.getProfile().getId())) {
            return save(dto);
        }

        dto.setProfile(profileService.createProfile(dto.getProfile()));
        return save(dto);

    }

    public boolean existsByID(String id) {
        return repository.existsByID(id);
    }

    public void deleteByID(String id) {
        deleteValidation(id);
        repository.deleteByID(id);
    }


    public PatientDTO findByID(String id) {
        if (!existsByID(id)) {
            throw new ResourceNotFoundException("Entity with id: " + id + " not found");
        }
        return mapper.entityToDto(repository.findByID(id));
    }


    public PatientDTO save(PatientDTO dto) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

    public void createValidation(PatientDTO dto) {
        // TODO
    }

    public void deleteValidation(String id) {
        if (!repository.existsByID(id)) {
            throw new ResourceNotFoundException("Patient with id: " + id + " does not exist");
        }
    }

    public PatientDTO update(PatientDTO dto) {
        if (!existsByID(dto.getId())) {
            throw new ResourceNotFoundException(
                    "Patient with id: " + dto.getId() + " does not exist");
        }


        dto.setProfile(profileService.update(dto.getProfile()));
        dto.getProfile().setDOB(dto.getProfile().getDOB().plusDays(1L));

        return save(dto);
    }
}
