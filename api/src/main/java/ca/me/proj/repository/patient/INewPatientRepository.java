package ca.me.proj.repository.patient;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.patient.NewPatientEntity;

@Repository
public interface INewPatientRepository extends CrudRepository<NewPatientEntity, Long> {

    @Override
    @Query(value = "SELECT * from PATIENT", nativeQuery = true)
    public List<NewPatientEntity> findAll();

}
