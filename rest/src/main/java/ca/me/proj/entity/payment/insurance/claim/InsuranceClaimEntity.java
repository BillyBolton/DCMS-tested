package ca.me.proj.entity.payment.insurance.claim;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import ca.me.proj.entity.payment.AbstractPaymentEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "INSURANCE_CLAIM")
public class InsuranceClaimEntity extends AbstractPaymentEntity {

    @Column(name = "policy_number")
    private String policyNumber;

    @Column(name = "group_number")
    private String groupNumber;

}
