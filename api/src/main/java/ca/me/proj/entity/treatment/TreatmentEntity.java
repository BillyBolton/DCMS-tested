package ca.me.proj.entity.treatment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TreatmentEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "medication")
    private String medication;

    @Column(name = "procetdure_id")
    private String procedureId;

    // @Column(name = "teeth")
    // private Character teeth;

    @Column(name = "symtoms")
    private String symtoms;

    @Column(name = "comments")
    private String comments;


}
