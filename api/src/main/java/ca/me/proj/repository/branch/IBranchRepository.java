package ca.me.proj.repository.branch;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.me.proj.entity.branch.BranchEntity;

public interface IBranchRepository extends JpaRepository<BranchEntity, String> {

    @Query(value = "SELECT CASE WHEN count(a)> 0 THEN true ELSE false end from Branch b where b.id = ?1",
            nativeQuery = true)
    public boolean existsByID(String id);

    @Override
    @Query(value = "SELECT * from Branch", nativeQuery = true)
    public List<BranchEntity> findAll();

    @Query(value = "SELECT * from Branch WHERE id = ?1 ", nativeQuery = true)
    public <Optional> BranchEntity findByID(String id);

    @Query(value = "DELETE from from Branch a where a.id = ?1", nativeQuery = true)
    public void deleteByID(String id);
}
