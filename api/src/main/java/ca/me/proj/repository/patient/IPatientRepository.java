package ca.me.proj.repository.patient;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.me.proj.entity.patient.PatientEntity;

public interface IPatientRepository extends JpaRepository<PatientEntity, String> {

    @Override
    @Query(value = "SELECT * from PATIENT", nativeQuery = true)
    public List<PatientEntity> findAll();

    @Query(value = "SELECT * from PATIENT WHERE id = ?1 ", nativeQuery = true)
    public <Optional> PatientEntity findByID(String id);

    @Query(value = "SELECT CASE WHEN count(p)> 0 THEN true ELSE false end from PATIENT p where p.id = ?1",
            nativeQuery = true)
    public boolean existsByID(String id);

    @Query(value = "DELETE from PATIENT p where p.id = ?1", nativeQuery = true)
    public void deleteByID(String id);

}
