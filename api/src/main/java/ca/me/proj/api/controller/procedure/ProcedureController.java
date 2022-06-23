package ca.me.proj.api.controller.procedure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.api.controller.base.AbstractCrudController;
import ca.me.proj.api.dtos.procedure.ProcedureDTO;
import ca.me.proj.api.entity.procedure.ProcedureEntity;

@RestController
@RequestMapping("/procedure")
public class ProcedureController
        extends AbstractCrudController<ProcedureDTO, ProcedureEntity, String> {

}
