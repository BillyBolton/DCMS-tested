package ca.me.proj.api.controller.treatment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.api.controller.base.AbstractCrudController;
import ca.me.proj.api.dtos.treatment.TreatmentDTO;
import ca.me.proj.api.entity.treatment.TreatmentEntity;
import ca.me.proj.api.service.treatment.TreatmentService;


@RestController
@RequestMapping("/treatment")
public class TreatmentController
        extends AbstractCrudController<TreatmentDTO, TreatmentEntity, Long> {

    @Autowired
    private TreatmentService treatmentService;



    @GetMapping("/exists/byProcedureId")
    public boolean existsById(@RequestParam String id) {
        return treatmentService.existsByProcedureId(id);
    }


    @GetMapping("/find/byProcedureId")
    public List<TreatmentDTO> findByProcedureId(@RequestParam String id) {
        return treatmentService.findByProcedureId(id);
    }

}

