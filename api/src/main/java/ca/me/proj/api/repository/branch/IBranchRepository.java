package ca.me.proj.api.repository.branch;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.branch.BranchEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IBranchRepository extends IBaseRepository<BranchEntity, String> {

    // @Query(value = "SELECT CASE WHEN count(b)> 0 THEN true ELSE false end from Branch b where
    // b.id = ?1",
    // nativeQuery = true)
    // public boolean existsById(String id);

    // @Override
    // @Query(value = "SELECT * from Branch", nativeQuery = true)
    // public List<BranchEntity> findAll();

    // @Query(value = "SELECT * from Branch WHERE id = ?1 ", nativeQuery = true)
    // public <Optional> BranchEntity findByID(String id);

    // @Modifying
    // @Query(value = "DELETE from Branch b where b.id = ?1", nativeQuery = true)
    // public void deleteByID(String id);
}
