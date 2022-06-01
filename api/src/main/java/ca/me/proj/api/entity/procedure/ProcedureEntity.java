package ca.me.proj.api.entity.procedure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "PROCEDURE")
public class ProcedureEntity {

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "tooth")
    private Character tooth;

    @Column(name = "procedure_count")
    private int procedureCount;

    // FKs
    @Column(name = "appointment_id")
    private Long appointmentId;

    @Column(name = "procedure_code")
    private String procedureCode;

    // @Column(name = "invoice_id")
    // private Long invoicedId;

}

