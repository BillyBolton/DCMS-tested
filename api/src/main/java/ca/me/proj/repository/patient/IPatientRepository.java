package ca.me.proj.repository.patient;

import org.springframework.data.repository.CrudRepository;
import ca.me.proj.entity.patient.PatientEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface IPatientRepository extends CrudRepository<PatientEntity,Long> {
    
    @Override
    @Query(value = "SELECT * from PATIENT", nativeQuery = true)
    public List<PatientEntity> findAll();
    
   
    @Query(value = "SELECT * from PATIENT WHERE id = ?1", nativeQuery = true)
    public PatientEntity findId(Long id);
}
