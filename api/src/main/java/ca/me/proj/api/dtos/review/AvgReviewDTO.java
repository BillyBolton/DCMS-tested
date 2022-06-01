package ca.me.proj.api.dtos.review;

import lombok.Data;

@Data
public class AvgReviewDTO {

    private String branchId;
    private Long professionalism;
    private Long communication;
    private Long cleanliness;
    private Long value;

}
