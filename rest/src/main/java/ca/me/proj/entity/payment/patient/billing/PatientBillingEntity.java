package ca.me.proj.entity.payment.patient.billing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import ca.me.proj.dtos.payment.PaymentType;
import ca.me.proj.entity.payment.AbstractPaymentEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PATIENT_BILLING")
public class PatientBillingEntity extends AbstractPaymentEntity {

    @Column(name = "card_number")
    private Long cardNumber;

    @Column(name = "expiry_date")
    private String expiryDate;

    @Column(name = "payment_type")
    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;

}
