package ca.me.proj.controller.treatment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.treatment.TreatmentDTO;
import ca.me.proj.service.treatment.TreatmentService;

@RestController
@RequestMapping("/Treatment")
public class TreatmentController {

    @Autowired
    private TreatmentService service;

    @GetMapping("/findAll")
    public List<TreatmentDTO> findAll() {
        return service.findAll();
    }
}
