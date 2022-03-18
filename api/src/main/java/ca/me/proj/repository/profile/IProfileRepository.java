package ca.me.proj.repository.profile;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.profile.ProfileEntity;

@Repository
public interface IProfileRepository extends CrudRepository<ProfileEntity, String> {

    @Override
    @Query(value = "SELECT * from PROFILE", nativeQuery = true)
    public List<ProfileEntity> findAll();

    @Query(value = "SELECT * from PROFILE WHERE username = ?1", nativeQuery = true)
    public ProfileEntity findByUsername(String username);

    @Query(value = "SELECT CASE WHEN count(p)> 0 THEN true ELSE false end from Profile p where p.username = ?1",
            nativeQuery = true)
    public Boolean existsByUsername(String username);



}
