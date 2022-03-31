package ca.me.proj.dtos.payment.patient.billing;

import ca.me.proj.dtos.payment.PaymentDTO;
import ca.me.proj.dtos.payment.PaymentType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PatientBillingDTO extends PaymentDTO {

    private Long cardNumber;

    private String expiryDate;

    private PaymentType paymentType;

}
