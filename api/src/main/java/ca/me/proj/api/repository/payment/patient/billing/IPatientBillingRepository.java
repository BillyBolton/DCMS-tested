package ca.me.proj.api.repository.payment.patient.billing;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.payment.patient.billing.PatientBillingEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IPatientBillingRepository extends IBaseRepository<PatientBillingEntity, Long> {

}
