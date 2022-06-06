package ca.me.proj.api.repository.patient;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.patient.PatientEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IPatientRepository extends IBaseRepository<PatientEntity, String> {

    // @Override
    // @Query(value = "SELECT * from PATIENT", nativeQuery = true)
    // public List<PatientEntity> findAll();

    // @Query(value = "SELECT * from PATIENT WHERE id = ?1 ", nativeQuery = true)
    // public <Optional> PatientEntity findByID(String id);

    // @Query(value = "SELECT CASE WHEN count(p)> 0 THEN true ELSE false end from PATIENT p where
    // p.id = ?1",
    // nativeQuery = true)
    // public boolean existsById(String id);

    // @Modifying
    // @Query(value = "DELETE from PATIENT p where p.id = ?1", nativeQuery = true)
    // public void deleteByID(String id);

}
