package ca.me.proj.api.repository.treatment;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.treatment.TreatmentEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface ITreatmentRepository extends IBaseRepository<TreatmentEntity, Long> {


        public List<TreatmentEntity> findByProcedureId(String id);

        public boolean existsByProcedureId(String id);

}
