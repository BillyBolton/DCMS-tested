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

        // @Override
        // @Query(value = "SELECT * from TREATMENT", nativeQuery = true)
        // public List<TreatmentEntity> findAll();

        // @Query(value = "SELECT * from TREATMENT WHERE id = ?1 ", nativeQuery = true)
        // public <Optional> TreatmentEntity findById(long id);

        // @Query(value = "SELECT CASE WHEN count(t)> 0 THEN true ELSE false end from TREATMENT t
        // where t.id = ?1",
        // nativeQuery = true)
        // public boolean existsById(long id);

        // @Modifying
        // @Query(value = "DELETE from Treatment t where t.id = ?1", nativeQuery = true)
        // public void deleteById(long id);

        // @Query(value = "SELECT CASE WHEN count(t)> 0 THEN true ELSE false end from TREATMENT t
        // where t.procedure_id = ?1",
        // nativeQuery = true)
        // public boolean existsByProcedureId(String id);

        // @Query(value = "SELECT * FROM TREATMENT WHERE procedure_id = ?1", nativeQuery = true)
        // public List<TreatmentEntity> findByProcedureId(String id);


}
