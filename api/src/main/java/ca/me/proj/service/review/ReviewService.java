package ca.me.proj.service.review;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.review.AvgReviewDTO;
import ca.me.proj.dtos.review.ReviewDTO;
import ca.me.proj.exceptions.ResourceNotFoundException;
import ca.me.proj.mapper.review.IReviewMapper;
import ca.me.proj.repository.branch.IBranchRepository;
import ca.me.proj.repository.patient.IPatientRepository;
import ca.me.proj.repository.review.IReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private IReviewMapper mapper;

    @Autowired
    private IReviewRepository repository;

    @Autowired
    private IBranchRepository branchRepository;

    @Autowired
    private IPatientRepository patientRepository;

    public List<ReviewDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public List<ReviewDTO> findByBranchId(String id) {
        if (!branchRepository.existsByID(id)) {
            throw new ResourceNotFoundException("Entity with id: " + id + " not found");
        }
        return mapper.entityToDto(repository.findByBranchId(id));
    }

    public AvgReviewDTO findAverageByBranchId(String id) {
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
        if (!patientRepository.existsByID(id)) {
            throw new ResourceNotFoundException("Entity with id: " + id + " not found");
        }
        return mapper.entityToDto(repository.findByPatientId(id));
    }

    public ReviewDTO createReview(ReviewDTO dto) {
        // dto.setId(null);
        createValidation(dto);
        return save(dto);
    }

    public ReviewDTO save(ReviewDTO dto) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

    public ReviewDTO update(ReviewDTO dto) {
        if (!repository.existsByID(dto.getId())) {
            throw new ResourceNotFoundException(
                    "Entity with id: " + dto.getId() + " does not exist");
        }
        return save(dto);
    }

    public void createValidation(ReviewDTO dto) {

        if (!branchRepository.existsByID(dto.getBranchId())) {
            throw new ResourceNotFoundException("Branch ID does not exist");
        }
        if (!patientRepository.existsByID(dto.getPatient().getId())) {
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

    public void deleteByID(Long id) {
        if (!repository.existsByID(id)) {
            throw new ResourceNotFoundException("Review ID does not exist");
        }
        repository.deleteByID(id);
    }
}
