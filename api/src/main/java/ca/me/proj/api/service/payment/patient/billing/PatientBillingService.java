package ca.me.proj.api.service.payment.patient.billing;

import org.springframework.stereotype.Service;
import ca.me.proj.api.dtos.payment.patient.billing.PatientBillingDTO;
import ca.me.proj.api.entity.payment.patient.billing.PatientBillingEntity;
import ca.me.proj.api.service.base.AbstractBaseServiceImpl;

@Service
public class PatientBillingService
        extends AbstractBaseServiceImpl<PatientBillingDTO, PatientBillingEntity, Long> {

}
