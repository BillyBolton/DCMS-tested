package ca.me.proj.api.repository.payment.patient.billing;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.payment.patient.billing.PatientBillingEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IPatientBillingRepository extends IBaseRepository<PatientBillingEntity, Long> {

    // @Override
    // @Query(value = "SELECT * from PATIENT_BILLING", nativeQuery = true)
    // public List<PatientBillingEntity> findAll();

    // @Query(value = "SELECT * from PATIENT_BILLING WHERE id = ?1 ", nativeQuery = true)
    // public <Optional> PatientBillingEntity findByID(long id);

    // @Query(value = "SELECT CASE WHEN count(p)> 0 THEN true ELSE false end from PATIENT_BILLING p
    // where p.id = ?1",
    // nativeQuery = true)
    // public boolean existsByID(long id);

    // @Modifying
    // @Query(value = "DELETE from PATIENT_BILLING p where p.id = ?1", nativeQuery = true)
    // public void deleteByID(long id);

}
