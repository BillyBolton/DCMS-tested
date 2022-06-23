package ca.me.proj.api.service.payment.insurance.claim;

import org.springframework.stereotype.Service;
import ca.me.proj.api.dtos.payment.insurance.claim.InsuranceClaimDTO;
import ca.me.proj.api.entity.payment.insurance.claim.InsuranceClaimEntity;
import ca.me.proj.api.service.base.AbstractBaseServiceImpl;

@Service
public class InsuranceClaimService
        extends AbstractBaseServiceImpl<InsuranceClaimDTO, InsuranceClaimEntity, Long> {

}
