package ca.me.proj.api.controller.payment.patient.billing;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.api.controller.base.AbstractCrudController;
import ca.me.proj.api.dtos.payment.patient.billing.PatientBillingDTO;
import ca.me.proj.api.entity.payment.patient.billing.PatientBillingEntity;

@RestController
@RequestMapping("/patient/billing")
public class PatientBillingController
        extends AbstractCrudController<PatientBillingDTO, PatientBillingEntity, Long> {


}
