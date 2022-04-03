package ca.me.proj.service.review;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.review.ReviewDTO;
import ca.me.proj.entity.response.CustomResponseEntity;
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
        return mapper.entityToDto(repository.findByBranchId(id));
    }

    public List<ReviewDTO> findByPatientId(String id) {
        return mapper.entityToDto(repository.findByPatientId(id));
    }

    public ResponseEntity<String> createReview(ReviewDTO dto) {
        dto.setId(null);
        if (!branchRepository.existsById(dto.getBranch().getId())) {
            return CustomResponseEntity.badRequestInvalidArgument("Branch ID does not exist");
        } else if (!patientRepository.existsById(dto.getPatient().getId())) {
            return CustomResponseEntity.badRequestInvalidArgument("Patient ID does not exists");
        } else if (dto.getProfessionalism() < 1 || dto.getProfessionalism() > 5) {
            return CustomResponseEntity
                    .badRequestInvalidArgument("Professionalism must be within 0-5");
        } else if (dto.getCommunication() < 1 || dto.getCommunication() > 5) {
            return CustomResponseEntity
                    .badRequestInvalidArgument("Communication must be within 0-5");
        } else if (dto.getCleanliness() < 1 || dto.getCleanliness() > 5) {
            return CustomResponseEntity.badRequestInvalidArgument("Cleanliness must be within 0-5");
        } else if (dto.getValue() < 1 || dto.getValue() > 5) {
            return CustomResponseEntity.badRequestInvalidArgument("Value must be within 0-5");
        } else {
            repository.save(mapper.dtoToEntity(dto));
            return CustomResponseEntity.saveSuccess();
        }
    }

    public ResponseEntity<String> deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return CustomResponseEntity.deleteSuccess();
        } else {
            return CustomResponseEntity.badRequestDNE();
        }
    }
}
