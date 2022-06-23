package ca.me.proj.api.service.procedure;

import org.springframework.stereotype.Service;
import ca.me.proj.api.dtos.procedure.ProcedureDTO;
import ca.me.proj.api.entity.procedure.ProcedureEntity;
import ca.me.proj.api.service.base.AbstractBaseServiceImpl;

@Service
public class ProcedureService
        extends AbstractBaseServiceImpl<ProcedureDTO, ProcedureEntity, String> {


}
