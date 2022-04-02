package ca.me.proj.entity.patient;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import ca.me.proj.entity.base.AbstractStringEntity;
import ca.me.proj.entity.profile.ProfileEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PATIENT")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class PatientEntity extends AbstractStringEntity {

    // @Id
    // @NotNull
    // @Column(name = "id")
    // private String id;

    @NotNull
    @Column(name = "email")
    private String email;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private ProfileEntity profile;
}
