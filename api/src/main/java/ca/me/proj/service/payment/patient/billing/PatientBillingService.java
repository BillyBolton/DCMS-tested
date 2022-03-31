package ca.me.proj.service.payment.patient.billing;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.payment.patient.billing.PatientBillingDTO;
import ca.me.proj.mapper.payment.patient.billing.IPatientBillingMapper;
import ca.me.proj.repository.payment.patient.billing.IPatientBillingRepository;

@Service
public class PatientBillingService {

    @Autowired
    private IPatientBillingMapper mapper;

    @Autowired
    private IPatientBillingRepository repository;

    public List<PatientBillingDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

}
