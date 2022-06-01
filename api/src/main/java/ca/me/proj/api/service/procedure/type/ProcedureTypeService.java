package ca.me.proj.api.service.procedure.type;

import org.springframework.stereotype.Service;
import ca.me.proj.api.dtos.procedure.type.ProcedureTypeDTO;
import ca.me.proj.api.entity.procedure.type.ProcedureTypeEntity;
import ca.me.proj.api.service.base.AbstractBaseServiceImpl;

@Service
public class ProcedureTypeService
        extends AbstractBaseServiceImpl<ProcedureTypeDTO, ProcedureTypeEntity, String> {

}
