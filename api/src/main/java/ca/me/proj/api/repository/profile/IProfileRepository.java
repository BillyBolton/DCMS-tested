package ca.me.proj.api.repository.profile;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.profile.ProfileEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IProfileRepository extends IBaseRepository<ProfileEntity, String> {

        public ProfileEntity findByUsername(String username);

        public boolean existsByUsername(String username);

        // @Override
        // @Query(value = "SELECT * from PROFILE", nativeQuery = true)
        // public List<ProfileEntity> findAll();

        // @Query(value = "SELECT * from PROFILE WHERE username = ?1", nativeQuery = true)
        // public ProfileEntity findByUsername(String username);

        // @Query(value = "SELECT CASE WHEN count(p)> 0 THEN true ELSE false end from Profile p
        // where p.username = ?1",
        // nativeQuery = true)
        // public boolean existsByUsername(String username);

        @Override
        @Query(value = "SELECT * from PROFILE WHERE id = ?1 ", nativeQuery = true)
        public Optional<ProfileEntity> findById(String id);

        // @Override
        // @Query(value = "SELECT CASE WHEN count(p)> 0 THEN true ELSE false end from PROFILE p
        // where p.id=?1",
        // nativeQuery = true)
        // public boolean existsById(String id);

        // @Modifying
        // @Query(value = "DELETE from PROFILE p where p.id = ?1", nativeQuery = true)
        // public void deleteByID(String id);


}
