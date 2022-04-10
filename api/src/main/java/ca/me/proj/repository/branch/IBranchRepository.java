package ca.me.proj.repository.branch;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.branch.BranchEntity;

@Transactional
@Repository
public interface IBranchRepository extends JpaRepository<BranchEntity, String> {

    @Query(value = "SELECT CASE WHEN count(b)> 0 THEN true ELSE false end from Branch b where b.id = ?1",
            nativeQuery = true)
    public boolean existsByID(String id);

    @Override
    @Query(value = "SELECT * from Branch", nativeQuery = true)
    public List<BranchEntity> findAll();

    @Query(value = "SELECT * from Branch WHERE id = ?1 ", nativeQuery = true)
    public <Optional> BranchEntity findByID(String id);

    @Modifying
    @Query(value = "DELETE from Branch b where b.id = ?1", nativeQuery = true)
    public void deleteByID(String id);
}
