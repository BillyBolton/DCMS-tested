package ca.me.proj.api.controller.procedure.type;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.api.controller.base.AbstractCrudController;
import ca.me.proj.api.dtos.procedure.type.ProcedureTypeDTO;
import ca.me.proj.api.entity.procedure.type.ProcedureTypeEntity;

@RestController
@RequestMapping("/procedure/type")
public class ProcedureTypeController
        extends AbstractCrudController<ProcedureTypeDTO, ProcedureTypeEntity, String> {

}
