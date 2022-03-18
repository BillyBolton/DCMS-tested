package ca.me.proj.repository.branch;

import org.springframework.data.repository.CrudRepository;

import ca.me.proj.entity.branch.BranchEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface IBranchRepository extends CrudRepository<BranchEntity,String> {
    
    @Override
    @Query(value = "SELECT * from BRANCH", nativeQuery = true)
    public List<BranchEntity> findAll();
}
