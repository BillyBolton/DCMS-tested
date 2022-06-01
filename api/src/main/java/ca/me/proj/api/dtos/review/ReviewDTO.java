package ca.me.proj.api.dtos.review;

import java.util.Date;
import ca.me.proj.api.dtos.base.BaseDTO;
import ca.me.proj.api.dtos.patient.PatientDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReviewDTO extends BaseDTO {

    private Long id;
    private Date date;
    private Long professionalism;
    private Long communication;
    private Long cleanliness;
    private Long value;
    private String comments;


    // FKS
    private String branchId;
    // private String patientId;

    // private BranchViewDTO branch;
    private PatientDTO patient;

}
