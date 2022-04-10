package ca.me.proj.controller.review;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.review.AvgReviewDTO;
import ca.me.proj.dtos.review.ReviewDTO;
import ca.me.proj.service.review.ReviewService;


@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping("/findAll")
    public List<ReviewDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("findAverageByBranchId")
    public AvgReviewDTO findAverage(@RequestParam String id) {
        return service.findAverageByBranchId(id);
    }

    @GetMapping("/findByBranchId")
    public List<ReviewDTO> findByBranchId(@RequestParam String id) {
        return service.findByBranchId(id);
    }

    @GetMapping("/findByPatientId")
    public List<ReviewDTO> findByPatientID(@RequestParam String id) {
        return service.findByPatientId(id);
    }

    @PostMapping("/create")
    public ReviewDTO createReview(@RequestBody ReviewDTO dto) {
        return service.createReview(dto);
    }

    @DeleteMapping("/deleteByID")
    public void deletebyID(@RequestParam Long id) {
        service.deleteByID(id);
    }

    @PutMapping("/update")
    public ReviewDTO update(@RequestBody ReviewDTO dto) {
        return service.update(dto);
    }

}
