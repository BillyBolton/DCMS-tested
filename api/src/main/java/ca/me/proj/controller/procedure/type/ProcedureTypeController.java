package ca.me.proj.controller.procedure.type;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.procedure.type.ProcedureTypeDTO;
import ca.me.proj.service.procedure.type.ProcedureTypeService;

@RestController
@RequestMapping("/procedure/type")
public class ProcedureTypeController {

    @Autowired
    private ProcedureTypeService service;

    @GetMapping("/findAll")
    public List<ProcedureTypeDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/existsByID")
    public boolean existsByID(@RequestParam String id) {
        return service.existsByID(id);
    }

    @GetMapping("/findByID")
    public ProcedureTypeDTO findByID(@RequestParam String id) {
        return service.findByID(id);
    }

}
