package ca.me.proj.api.repository.patient;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.patient.NewPatientEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface INewPatientRepository extends IBaseRepository<NewPatientEntity, Long> {

    // @Override
    // @Query(value = "SELECT * from PATIENT", nativeQuery = true)
    // public List<NewPatientEntity> findAll();

}
