package ca.me.proj.controller.payment.patient.billing;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.payment.patient.billing.PatientBillingDTO;
import ca.me.proj.service.payment.patient.billing.PatientBillingService;

@RestController
@RequestMapping("/patient/billing")
public class PatientBillingController {

    @Autowired
    private PatientBillingService service;

    @GetMapping("/findAll")
    public List<PatientBillingDTO> findAll() {
        return service.findAll();
    }

}
