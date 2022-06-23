package ca.me.proj.api.repository.review;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.review.ReviewEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IReviewRepository extends IBaseRepository<ReviewEntity, Long> {

    public List<ReviewEntity> findByBranchId(String id);

    public List<ReviewEntity> findByPatientId(String id);

}
