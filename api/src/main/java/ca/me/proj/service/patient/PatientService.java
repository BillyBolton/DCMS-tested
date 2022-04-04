package ca.me.proj.service.patient;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.patient.NewPatientDTO;
import ca.me.proj.dtos.patient.PatientDTO;
import ca.me.proj.entity.response.CustomResponseEntity;
import ca.me.proj.mapper.patient.INewPatientMapper;
import ca.me.proj.mapper.patient.IPatientMapper;
import ca.me.proj.repository.patient.INewPatientRepository;
import ca.me.proj.repository.patient.IPatientRepository;
import ca.me.proj.repository.profile.IProfileRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientService {


    @Autowired
    private IPatientMapper mapper;

    @Autowired
    private INewPatientMapper newPatientMapper;

    @Autowired
    private INewPatientRepository newPatientRepository;

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IProfileRepository profileRepository;

    public List<PatientDTO> findAll() {
        return mapper.entityToDto(patientRepository.findAll());
    }

    public PatientDTO createPatient(PatientDTO dto) {


        // If ID does not exist in Profile repo
        // if (!profileRepository.existsById(dto.getId())) {
        // throw new ResourceNotFoundException("Profile ID does not exist");
        // }
        return newPatientMapper
                .entityToDto(newPatientRepository.save(newPatientMapper.dtoToEntity(dto)));

    }

    public boolean existsByID(String id) {
        return patientRepository.existsById(id);
    }

    public ResponseEntity<String> deletePatientByID(String id) {
        if (!patientRepository.existsById(id)) {
            return CustomResponseEntity.badRequestDNE();
        }

        patientRepository.deleteById(id);
        return CustomResponseEntity.deleteSuccess();
    }

    public ResponseEntity<String> updateEmail(PatientDTO dto) {
        if (patientRepository.existsById(dto.getId())) {
            patientRepository.save(mapper.dtoToEntity(dto));
            return CustomResponseEntity.updateSuccess();
        }
        return CustomResponseEntity.badRequestDNE();
    }

    public PatientDTO findById(String id) {
        return mapper.entityToDto(patientRepository.findById(id).orElse(null));
    }
}
