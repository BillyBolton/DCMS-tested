package ca.me.proj.entity.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@MappedSuperclass
public class AbstractStringEntity {

    /**
    * 
    */
    private static final long serialVersionUID = 4779878072564389796L;

    @NotNull(message = "ID cannot be null for Entity")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

}
