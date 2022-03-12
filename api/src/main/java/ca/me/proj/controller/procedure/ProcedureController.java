package ca.me.proj.controller.procedure;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
