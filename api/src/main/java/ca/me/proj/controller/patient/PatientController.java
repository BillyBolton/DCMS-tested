package ca.me.proj.controller.patient;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.patient.PatientDTO;
import ca.me.proj.service.patient.PatientService;


@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService service;

    @GetMapping("/findAll")
    public List<PatientDTO> findAll() {
        return service.findAll();
    }

    // @PostMapping("/create/new")
    // public NewPatientDTO createPatient(@RequestBody NewPatientDTO dto) {
    // return service.createPatient(dto);
    // }

    @PostMapping("/create")
    public PatientDTO createPatient(@RequestBody PatientDTO dto) {
        return service.createPatient(dto);
    }

    @GetMapping("/existsByID")
    public boolean existsByID(@RequestParam String id) {
        return service.existsByID(id);
    }

    @GetMapping("/findByID")
    public PatientDTO findByID(@RequestParam String id) {
        return service.findByID(id);
    }


    @DeleteMapping("/deleteByID")
    public void deletePatientByID(@RequestParam String id) {
        service.deleteByID(id);
    }

    @PutMapping("/update")
    public PatientDTO update(@RequestBody PatientDTO dto) {
        return service.update(dto);
    }



}
