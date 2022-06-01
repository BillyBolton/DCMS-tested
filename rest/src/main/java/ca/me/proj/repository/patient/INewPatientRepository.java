package ca.me.proj.repository.patient;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.patient.NewPatientEntity;

@Transactional
@Repository
public interface INewPatientRepository extends JpaRepository<NewPatientEntity, Long> {

    @Override
    @Query(value = "SELECT * from PATIENT", nativeQuery = true)
    public List<NewPatientEntity> findAll();

}
