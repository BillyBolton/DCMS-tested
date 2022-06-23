package ca.me.proj.api.entity.payment;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import ca.me.proj.api.entity.base.AbstractBaseEntity;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class AbstractPaymentEntity extends AbstractBaseEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date")
    private Date date;

    // private Long invoiceId;



}
