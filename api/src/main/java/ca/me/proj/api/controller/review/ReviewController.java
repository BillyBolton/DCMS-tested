package ca.me.proj.api.controller.review;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.api.controller.base.AbstractCrudController;
import ca.me.proj.api.dtos.review.AvgReviewDTO;
import ca.me.proj.api.dtos.review.ReviewDTO;
import ca.me.proj.api.entity.review.ReviewEntity;
import ca.me.proj.api.service.review.ReviewService;


@RestController
@RequestMapping("/review")
public class ReviewController extends AbstractCrudController<ReviewDTO, ReviewEntity, Long> {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/find/averageRating/byBranchId")
    public AvgReviewDTO findAverageRating(@RequestParam String id) {
        return reviewService.findAverageRatingByBranchId(id);
    }

    @GetMapping("/find/byBranchId")
    public List<ReviewDTO> findByBranchId(@RequestParam String id) {
        return reviewService.findByBranchId(id);
    }

    @GetMapping("/find/byPatientId")
    public List<ReviewDTO> findByPatientID(@RequestParam String id) {
        return reviewService.findByPatientId(id);
    }



}
