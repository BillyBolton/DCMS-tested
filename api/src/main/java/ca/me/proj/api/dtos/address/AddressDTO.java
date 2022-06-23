package ca.me.proj.api.dtos.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ca.me.proj.api.constants.province.Province;
import ca.me.proj.api.dtos.base.BaseDTO;
import ca.me.proj.api.dtos.branch.BranchDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class AddressDTO extends BaseDTO {

    private static final long servialVersionUID = 5394857629837459234L;

    private String id;
    private Long buildingNumber;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    @JsonIgnore
    private BranchDTO branch;

}
