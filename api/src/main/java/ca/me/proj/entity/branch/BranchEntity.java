package ca.me.proj.entity.branch;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "BRANCH")
public class BranchEntity {

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Id
    @Column(name = "id")
    private String id;

    // FK
    @Column(name = "manager_id")
    private String manager_id;

    @NotNull
    @Column(name = "address_id")
    private String address_id;
}
