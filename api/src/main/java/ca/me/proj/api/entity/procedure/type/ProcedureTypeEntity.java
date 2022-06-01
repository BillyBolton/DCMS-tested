package ca.me.proj.api.entity.procedure.type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import ca.me.proj.api.entity.base.AbstractBaseEntity;
import lombok.Data;

@Data
@Entity
@Table(name = "PROCEDURE_TYPE")
public class ProcedureTypeEntity extends AbstractBaseEntity {

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "type")
    private String type;

}
