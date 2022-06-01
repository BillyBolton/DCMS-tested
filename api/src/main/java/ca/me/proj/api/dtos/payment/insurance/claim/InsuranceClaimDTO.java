package ca.me.proj.api.dtos.payment.insurance.claim;

import ca.me.proj.api.dtos.payment.PaymentDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InsuranceClaimDTO extends PaymentDTO {

    private String policyNumber;

    private String groupNumber;

}
