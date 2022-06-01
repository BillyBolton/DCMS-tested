package ca.me.proj.api.repository.review;


import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.review.ReviewEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IReviewRepository extends IBaseRepository<ReviewEntity, Long> {
    // @Override
    // @Query(value = "SELECT * from REVIEW", nativeQuery = true)
    // public List<ReviewEntity> findAll();

    // @Query(value = "SELECT * from PATIENT WHERE id = ?1 ", nativeQuery = true)
    // public <Optional> ReviewEntity findByID(long id);

    // @Query(value = "SELECT CASE WHEN count(r)> 0 THEN true ELSE false end from REVIEW r where
    // r.id = ?1",
    // nativeQuery = true)
    // public boolean existsByID(long id);

    // @Modifying
    // @Query(value = "DELETE from REVIEW p where p.id = ?1", nativeQuery = true)
    // public void deleteByID(long id);

    // @Query(value = "SELECT * FROM REVIEW WHERE branch_id = ?1", nativeQuery = true)
    // public List<ReviewEntity> findByBranchId(String id);

    // @Query(value = "SELECT * FROM REVIEW WHERE patient_id = ?1", nativeQuery = true)
    // public List<ReviewEntity> findByPatientId(String id);



}