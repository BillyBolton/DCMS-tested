package ca.me.proj.controller.procedure;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.procedure.ProcedureDTO;
import ca.me.proj.service.procedure.ProcedureService;

@RestController
@RequestMapping("/procedure")
public class ProcedureController {

    @Autowired
    private ProcedureService service;

    @GetMapping("/findAll")
    public List<ProcedureDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/existsByID")
    public boolean existsByID(@RequestParam String id) {
        return service.existsByID(id);
    }

    @GetMapping("/findByID")
    public ProcedureDTO findByID(@RequestParam String id) {
        return service.findByID(id);
    }

    @PostMapping("/create")
    public ProcedureDTO createProcedure(@RequestBody ProcedureDTO dto) {
        return service.createProcedure(dto);
    }

    @DeleteMapping("/deleteByID")
    public void deletebyId(@RequestParam String id) {
        service.deletebyId(id);
    }


}
