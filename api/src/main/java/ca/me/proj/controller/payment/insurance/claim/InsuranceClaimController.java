package ca.me.proj.controller.payment.insurance.claim;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.payment.insurance.claim.InsuranceClaimDTO;
import ca.me.proj.service.payment.insurance.claim.InsuranceClaimService;

@RestController
@RequestMapping("/insurance/claim")
public class InsuranceClaimController {

    @Autowired
    private InsuranceClaimService service;

    @GetMapping("/findAll")
    public List<InsuranceClaimDTO> findAll() {
        return service.findAll();
    }

}
