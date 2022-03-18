package ca.me.proj.entity.address;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Address")
public class AddressEntity implements Serializable {

    @EmbeddedId
    private AddressId id;

}
