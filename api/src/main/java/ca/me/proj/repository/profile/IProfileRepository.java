package ca.me.proj.repository.profile;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.profile.ProfileEntity;

@Repository
public interface IProfileRepository extends CrudRepository<ProfileEntity, Long> {
    
    @Override
    @Query(value = "SELECT * from PROFILE", nativeQuery = true)
    public List<ProfileEntity> findAll();
}
