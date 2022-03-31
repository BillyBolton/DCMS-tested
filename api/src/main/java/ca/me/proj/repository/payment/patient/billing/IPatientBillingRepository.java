package ca.me.proj.repository.payment.patient.billing;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.payment.patient.billing.PatientBillingEntity;

@Repository
public interface IPatientBillingRepository extends CrudRepository<PatientBillingEntity, Long> {


}
