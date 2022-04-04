package ca.me.proj.dtos.branch;

import ca.me.proj.dtos.address.AddressDTO;
import ca.me.proj.dtos.base.BaseStringDTO;
import ca.me.proj.dtos.employee.ManagerDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BranchViewDTO extends BaseStringDTO {

    private ManagerDTO manager;

    private AddressDTO address;

}
