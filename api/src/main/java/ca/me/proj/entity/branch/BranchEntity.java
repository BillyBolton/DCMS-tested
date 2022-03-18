package ca.me.proj.entity.branch;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Table(name = "BRANCH")
public class BranchEntity {
    @NotNull
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    //FK
    @Column(name = "manager_id")
    private String manager_id;

    @NotNull
    @Column(name = "address_id")
    private long address_id;
}
