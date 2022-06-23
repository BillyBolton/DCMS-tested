package ca.me.proj.api.repository.procedure.type;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.procedure.type.ProcedureTypeEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IProcedureTypeRepository extends IBaseRepository<ProcedureTypeEntity, String> {

}
