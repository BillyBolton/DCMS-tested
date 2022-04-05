package ca.me.proj.repository.payment.insurance.claim;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.payment.insurance.claim.InsuranceClaimEntity;

@Repository
public interface IInsuranceClaimRepository extends JpaRepository<InsuranceClaimEntity, Long> {

}
