package ca.me.proj.dtos.branch;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BranchDTO {
    //PK
    private String id;

    //FK
    private String manager_id;
    private long address_id;


}
