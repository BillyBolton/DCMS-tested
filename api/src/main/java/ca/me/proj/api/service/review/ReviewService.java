package ca.me.proj.api.service.review;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.api.dtos.exceptions.ResourceNotFoundException;
import ca.me.proj.api.dtos.review.AvgReviewDTO;
import ca.me.proj.api.dtos.review.ReviewDTO;
import ca.me.proj.api.entity.review.ReviewEntity;
import ca.me.proj.api.repository.branch.IBranchRepository;
import ca.me.proj.api.repository.patient.IPatientRepository;
import ca.me.proj.api.repository.review.IReviewRepository;
import ca.me.proj.api.service.base.AbstractBaseServiceImpl;

@Service
public class ReviewService extends AbstractBaseServiceImpl<ReviewDTO, ReviewEntity, Long> {


    @Autowired
    private IReviewRepository reviewRepository;

    @Autowired
    private IBranchRepository branchRepository;

    @Autowired
    private IPatientRepository patientRepository;

    public List<ReviewDTO> findByBranchId(String id) {
        if (!branchRepository.existsById(id)) {
            throw new ResourceNotFoundException("Entity with id: " + id + " not found");
        }
        return mapper.entityToDto(reviewRepository.findByBranchId(id));
    }

    public AvgReviewDTO findAverageRatingByBranchId(String id) {
        List<ReviewDTO> dtos = findByBranchId(id);
        AvgReviewDTO avg = new AvgReviewDTO();

        if (dtos.isEmpty()) {
            avg.setBranchId(id);
            avg.setProfessionalism(0L);
            avg.setCommunication(0L);
            avg.setCleanliness(0L);
            avg.setValue(0L);
            return avg;
        }

        Long professionalism = 0L;
        Long communication = 0L;
        Long cleanliness = 0L;
        Long value = 0L;

        for (ReviewDTO dto : dtos) {
            professionalism += dto.getProfessionalism();
            communication += dto.getCommunication();
            cleanliness += dto.getCleanliness();
            value += dto.getValue();
        }

        avg.setBranchId(id);
        avg.setProfessionalism(professionalism / dtos.size());
        avg.setCommunication(communication / dtos.size());
        avg.setCleanliness(cleanliness / dtos.size());
        avg.setValue(value / dtos.size());

        return avg;
    }

    public List<ReviewDTO> findByPatientId(String id) {
        if (!patientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Entity with id: " + id + " not found");
        }
        return mapper.entityToDto(reviewRepository.findByPatientId(id));
    }

    public ReviewDTO createReview(ReviewDTO dto) {
        // dto.setId(null);
        createValidation(dto);
        return save(dto);
    }



    public ReviewDTO update(ReviewDTO dto) {
        if (!repository.existsById(dto.getId())) {
            throw new ResourceNotFoundException(
                    "Entity with id: " + dto.getId() + " does not exist");
        }
        return save(dto);
    }

    public void createValidation(ReviewDTO dto) {

        if (!branchRepository.existsById(dto.getBranchId())) {
            throw new ResourceNotFoundException("Branch ID does not exist");
        }
        if (!patientRepository.existsById(dto.getPatient().getId())) {
            throw new ResourceNotFoundException("Patient ID does not exist");
        }
        if (dto.getProfessionalism() < 1 && dto.getProfessionalism() > 5) {
            throw new IllegalArgumentException("Professionalism must be between 1 and 5");
        }
        if (dto.getCommunication() < 1 && dto.getCommunication() > 5) {
            throw new IllegalArgumentException("Communication must be between 1 and 5");
        }
        if (dto.getCleanliness() < 1 && dto.getCleanliness() > 5) {
            throw new IllegalArgumentException("Cleanliness must be between 1 and 5");
        }
        if (dto.getValue() < 1 && dto.getValue() > 5) {
            throw new IllegalArgumentException("Value must be between 1 and 5");
        }

    }

}
