package ca.me.proj.entity.payment;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class AbstractPaymentEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date")
    private Date date;

    // private Long invoiceId;



}
