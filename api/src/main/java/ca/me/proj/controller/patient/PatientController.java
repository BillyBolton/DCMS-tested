package ca.me.proj.controller.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.patient.PatientDTO;
import ca.me.proj.service.patient.PatientService;
import io.micrometer.core.ipc.http.HttpSender.Response;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/findAll")
    public List<PatientDTO> findAll() {
        return patientService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPatient(@RequestBody PatientDTO patientDTO){
        ResponseEntity<String> response = patientService.createPatient(patientDTO);
        return response;
    }
    
    @GetMapping("/existsByID")
    public boolean existsByID(@RequestParam String id){
        return patientService.existsByID(id);
    }

    @DeleteMapping("/deleteByID")
    public ResponseEntity<String> deletePatientByID(@RequestParam String id){
        return patientService.deletePatientByID(id);
    }

    @PatchMapping("/updateEmail")
    public ResponseEntity<String> updateEmail(@RequestBody PatientDTO patientDTO){
        return patientService.updateEmail(patientDTO);
    }


    
}
