package ca.me.proj.dtos.review;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReviewDTO {

    private Long id;
    private Date date;
    private Long professionalism;
    private Long communication;
    private Long cleanliness;
    private Long value;
    private String comments;
    

    // FKS
    private String branchId;
    private String patientId;

}
