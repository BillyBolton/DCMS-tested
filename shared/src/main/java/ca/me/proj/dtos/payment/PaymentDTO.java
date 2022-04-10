package ca.me.proj.dtos.payment;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
public abstract class PaymentDTO implements Serializable {

    private Long id;

    private double amount;

    private LocalDate date;

    // private Long invoiceId;

}
