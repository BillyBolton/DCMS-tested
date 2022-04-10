package ca.me.proj.repository.profile;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.profile.ProfileEntity;

@Transactional
@Repository
public interface IProfileRepository extends JpaRepository<ProfileEntity, String> {

        @Override
        @Query(value = "SELECT * from PROFILE", nativeQuery = true)
        public List<ProfileEntity> findAll();

        @Query(value = "SELECT * from PROFILE WHERE username = ?1", nativeQuery = true)
        public ProfileEntity findByUsername(String username);

        @Query(value = "SELECT CASE WHEN count(p)> 0 THEN true ELSE false end from Profile p where p.username = ?1",
                        nativeQuery = true)
        public boolean existsByUsername(String username);

        @Query(value = "SELECT * from PROFILE WHERE id = ?1 ", nativeQuery = true)
        public <Optional> ProfileEntity findByID(String id);

        @Query(value = "SELECT CASE WHEN count(p)> 0 THEN true ELSE false end from PROFILE p where p.id = ?1",
                        nativeQuery = true)
        public boolean existsByID(String id);

        @Modifying
        @Query(value = "DELETE from PROFILE p where p.id = ?1", nativeQuery = true)
        public void deleteByID(String id);


}
