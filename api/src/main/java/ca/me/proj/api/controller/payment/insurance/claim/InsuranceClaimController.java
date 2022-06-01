package ca.me.proj.api.controller.payment.insurance.claim;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.api.controller.base.AbstractCrudController;
import ca.me.proj.api.dtos.payment.insurance.claim.InsuranceClaimDTO;
import ca.me.proj.api.entity.payment.insurance.claim.InsuranceClaimEntity;

@RestController
@RequestMapping("/insurance/claim")
public class InsuranceClaimController
        extends AbstractCrudController<InsuranceClaimDTO, InsuranceClaimEntity, Long> {

}
