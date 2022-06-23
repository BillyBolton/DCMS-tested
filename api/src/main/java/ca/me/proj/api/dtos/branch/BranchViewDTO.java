package ca.me.proj.api.dtos.branch;

import ca.me.proj.api.dtos.address.AddressDTO;
import ca.me.proj.api.dtos.base.BaseStringDTO;
import ca.me.proj.api.dtos.employee.ManagerDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BranchViewDTO extends BaseStringDTO {

    private ManagerDTO manager;

    private AddressDTO address;

}
