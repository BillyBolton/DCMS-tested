package ca.me.proj.controller.treatment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.treatment.TreatmentDTO;
import ca.me.proj.service.treatment.TreatmentService;


@RestController
@RequestMapping("/treatment")
public class TreatmentController {

    @Autowired
    private TreatmentService service;

    @GetMapping("/findAll")
    public List<TreatmentDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/existsById")
    public boolean existsById(@RequestParam Long id) {
        return service.existsById(id);
    }

    @GetMapping("/existsByProcedureId")
    public boolean existsById(@RequestParam String id) {
        return service.existsByProcedureId(id);
    }

    @GetMapping("/findById")
    public TreatmentDTO findById(@RequestParam Long id) {
        return service.findById(id);
    }

    @GetMapping("/findByProcedureId")
    public List<TreatmentDTO> findByProcedureId(@RequestParam String id) {
        return service.findByProcedureId(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTreatment(@RequestBody TreatmentDTO dto) {
        return service.createTreatment(dto);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deletebyId(@RequestParam Long id) {
        return service.deleteById(id);
    }
}

