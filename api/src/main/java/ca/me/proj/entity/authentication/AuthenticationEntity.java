package ca.me.proj.entity.authentication;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import ca.me.proj.rest.components.entity.base.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Authentication")
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class AuthenticationEntity extends AbstractBaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
