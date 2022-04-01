package ca.me.proj.controller.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/findByBranchId")
    public List<ReviewDTO> findByBranchId(@RequestParam String id) {
        return service.findByBranchId(id);
    }

    @GetMapping("/findByPatientId")
    public List<ReviewDTO> findByPatientId(@RequestParam String id) {
        return service.findByPatientId(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createReview(@RequestBody ReviewDTO dto) {
        return service.createReview(dto);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deletebyId(@RequestParam Long id) {
        return service.deleteById(id);
    }

}
