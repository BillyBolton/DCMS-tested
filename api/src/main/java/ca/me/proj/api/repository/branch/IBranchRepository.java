package ca.me.proj.api.repository.branch;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.branch.BranchEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IBranchRepository extends IBaseRepository<BranchEntity, String> {

}
