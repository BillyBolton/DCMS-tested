package ca.me.proj.entity.employee;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import ca.me.proj.entity.base.AbstractStringEntity;
import ca.me.proj.entity.profile.ProfileEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "EMPLOYEE")
public class ManagerEntity extends AbstractStringEntity {

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private ProfileEntity profile;

}

