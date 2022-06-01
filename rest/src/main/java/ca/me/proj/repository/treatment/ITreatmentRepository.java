package ca.me.proj.repository.treatment;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.treatment.TreatmentEntity;

@Transactional
@Repository
public interface ITreatmentRepository extends JpaRepository<TreatmentEntity, Long> {


        @Override
        @Query(value = "SELECT * from TREATMENT", nativeQuery = true)
        public List<TreatmentEntity> findAll();

        @Query(value = "SELECT * from TREATMENT WHERE id = ?1 ", nativeQuery = true)
        public <Optional> TreatmentEntity findByID(long id);

        @Query(value = "SELECT CASE WHEN count(t)> 0 THEN true ELSE false end from TREATMENT t where t.id = ?1",
                        nativeQuery = true)
        public boolean existsByID(long id);

        @Modifying
        @Query(value = "DELETE from Treatment t where t.id = ?1", nativeQuery = true)
        public void deleteByID(long id);

        @Query(value = "SELECT CASE WHEN count(t)> 0 THEN true ELSE false end from TREATMENT t where t.procedure_id = ?1",
                        nativeQuery = true)
        public boolean existsByProcedureId(String id);

        @Query(value = "SELECT * FROM TREATMENT WHERE procedure_id = ?1", nativeQuery = true)
        public List<TreatmentEntity> findByProcedureId(String id);


}
