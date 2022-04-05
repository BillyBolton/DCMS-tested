package ca.me.proj.repository.payment.patient.billing;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.payment.patient.billing.PatientBillingEntity;

@Repository
public interface IPatientBillingRepository extends JpaRepository<PatientBillingEntity, Long> {

    @Override
    @Query(value = "SELECT * from PATIENT_BILLING", nativeQuery = true)
    public List<PatientBillingEntity> findAll();

    @Query(value = "SELECT * from PATIENT_BILLING WHERE id = ?1 ", nativeQuery = true)
    public <Optional> PatientBillingEntity findByID(long id);

    @Query(value = "SELECT CASE WHEN count(p)> 0 THEN true ELSE false end from PATIENT_BILLING p where p.id = ?1",
            nativeQuery = true)
    public boolean existsByID(long id);

    @Query(value = "DELETE from from PATIENT_BILLING p where p.id = ?1", nativeQuery = true)
    public void deleteByID(long id);

}
