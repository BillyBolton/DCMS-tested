package ca.me.proj.service.patient;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.patient.PatientDTO;
import ca.me.proj.mapper.patient.IPatientMapper;
import ca.me.proj.repository.patient.IPatientRepository;
import ca.me.proj.repository.profile.IProfileRepository;

@Service
public class PatientService {
    @Autowired
    private IPatientMapper mapper;

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IProfileRepository profileRepository;

    public List<PatientDTO> findAll() {
        return mapper.entityToDto(patientRepository.findAll());
    }

    public ResponseEntity<String> createPatient(PatientDTO patientDTO){
        if(!profileRepository.existsById(patientDTO.getId())){
            return new ResponseEntity<String>(
                "ID does not exist", 
                HttpStatus.BAD_REQUEST);
        }else{
            patientRepository.save(mapper.dtoToEntity(patientDTO));
            return new ResponseEntity<String>("Success",HttpStatus.ACCEPTED);
        }

    }

    public boolean existsByID(Long id){
        return patientRepository.existsById(id);
    }

    public ResponseEntity<String> deletePatientByID(Long id){
            if(patientRepository.existsById(id)){
                patientRepository.deleteById(id);
                return new ResponseEntity<String>("Success: Deleted ID: " + id,HttpStatus.ACCEPTED);
            }
            else{
                //Not sure what proper syntax here would be if not a Response Entity
                return new ResponseEntity<String>(
                "ID does not exist", 
                HttpStatus.BAD_REQUEST);
            }
        
        
    }
    public ResponseEntity<String> updateEmail(PatientDTO patientDTO){
        if(patientRepository.existsById(patientDTO.getId())){
            patientRepository.save(mapper.dtoToEntity(patientDTO));
            return new ResponseEntity<String>("Success: Updated Email: " + patientDTO.getEmail(),HttpStatus.ACCEPTED);
        }else{
                return new ResponseEntity<String>(
                "ID does not exist", 
                HttpStatus.BAD_REQUEST);
        }
    }



}
