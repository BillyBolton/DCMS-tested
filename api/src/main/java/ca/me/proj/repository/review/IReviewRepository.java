package ca.me.proj.repository.review;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.me.proj.entity.review.ReviewEntity;

public interface IReviewRepository extends JpaRepository<ReviewEntity, Long> {
    @Override
    @Query(value = "SELECT * from REVIEW", nativeQuery = true)
    public List<ReviewEntity> findAll();

    @Query(value = "SELECT * from PATIENT WHERE id = ?1 ", nativeQuery = true)
    public <Optional> ReviewEntity findByID(long id);

    @Query(value = "SELECT CASE WHEN count(r)> 0 THEN true ELSE false end from REVIEW r where r.id = ?1",
            nativeQuery = true)
    public boolean existsByID(long id);

    @Query(value = "DELETE from REVIEW p where p.id = ?1", nativeQuery = true)
    public void deleteByID(long id);

    @Query(value = "SELECT * FROM REVIEW WHERE branch_id = ?1", nativeQuery = true)
    public List<ReviewEntity> findByBranchId(String id);

    @Query(value = "SELECT * FROM REVIEW WHERE patient_id = ?1", nativeQuery = true)
    public List<ReviewEntity> findByPatientId(String id);



}
