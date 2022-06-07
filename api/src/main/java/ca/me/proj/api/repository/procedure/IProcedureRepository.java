package ca.me.proj.api.repository.procedure;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.procedure.ProcedureEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IProcedureRepository extends IBaseRepository<ProcedureEntity, String> {

}
