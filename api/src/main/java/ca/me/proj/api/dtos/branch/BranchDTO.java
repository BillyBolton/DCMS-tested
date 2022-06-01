package ca.me.proj.api.dtos.branch;

import java.util.List;
import ca.me.proj.api.dtos.address.AddressDTO;
import ca.me.proj.api.dtos.base.BaseDTO;
import ca.me.proj.api.dtos.employee.ManagerDTO;
import ca.me.proj.api.dtos.procedure.type.ProcedureTypeDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BranchDTO extends BaseDTO {
    // PK
    private String id;

    // FK
    // private String manager_id;
    private ManagerDTO manager;

    private AddressDTO address;
    // private String address_id;

    private List<ProcedureTypeDTO> procedures;

}
