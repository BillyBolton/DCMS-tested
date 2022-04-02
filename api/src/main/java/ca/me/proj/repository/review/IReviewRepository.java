package ca.me.proj.repository.review;


import org.springframework.data.repository.CrudRepository;

import ca.me.proj.entity.review.ReviewEntity;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface IReviewRepository extends CrudRepository<ReviewEntity,Long> {
    @Override
    @Query(value = "SELECT * from REVIEW", nativeQuery = true)
    public List<ReviewEntity> findAll();


    @Query(value = "SELECT * FROM REVIEW WHERE branch_id = ?1", nativeQuery = true)
    public List<ReviewEntity> findByBranchId (String id);

    @Query(value = "SELECT * FROM REVIEW WHERE patient_id = ?1", nativeQuery = true)
    public List<ReviewEntity> findByPatientId (String id);
}
