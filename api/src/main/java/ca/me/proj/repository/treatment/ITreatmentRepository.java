package ca.me.proj.repository.treatment;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.treatment.TreatmentEntity;

@Repository
public interface ITreatmentRepository extends CrudRepository<TreatmentEntity, Long> {

    @Query(value = "SELECT CASE WHEN count(t)> 0 THEN true ELSE false end from TREATMENT t where t.procedure_id = ?1", nativeQuery = true)
    public boolean existsByProcedureId (String id);

    @Query(value = "SELECT * FROM TREATMENT WHERE procedure_id = ?1", nativeQuery = true)
    public List<TreatmentEntity> findByProcedureId (String id);
}
