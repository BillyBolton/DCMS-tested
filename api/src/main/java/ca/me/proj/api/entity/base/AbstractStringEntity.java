package ca.me.proj.api.entity.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class AbstractStringEntity extends AbstractBaseEntity {

    /**
    * 
    */
    private static final long serialVersionUID = 4779878072564389796L;

    // @NotNull(message = "ID cannot be null for Entity")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

}
