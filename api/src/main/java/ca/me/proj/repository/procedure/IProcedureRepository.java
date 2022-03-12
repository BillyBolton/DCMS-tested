package ca.me.proj.repository.procedure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.procedure.ProcedureEntity;

@Repository
public interface IProcedureRepository extends CrudRepository<ProcedureEntity, Long> {


}
