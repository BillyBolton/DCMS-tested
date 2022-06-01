package ca.me.proj.api.repository.payment.insurance.claim;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.payment.insurance.claim.InsuranceClaimEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IInsuranceClaimRepository extends IBaseRepository<InsuranceClaimEntity, Long> {

}
