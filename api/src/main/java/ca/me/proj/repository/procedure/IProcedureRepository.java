package ca.me.proj.repository.procedure;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.procedure.ProcedureEntity;

@Repository
public interface IProcedureRepository extends JpaRepository<ProcedureEntity, String> {

    @Override
    @Query(value = "SELECT * from PROCEDURE", nativeQuery = true)
    public List<ProcedureEntity> findAll();

    @Query(value = "SELECT * from PROCEDURE WHERE id = ?1", nativeQuery = true)
    public Optional<ProcedureEntity> findByID(String id);

    @Query(value = "SELECT CASE WHEN count(a)> 0 THEN true ELSE false end from PROCEDURE p where p.id = ?1",
            nativeQuery = true)
    public boolean existsByID(String id);

    @Query(value = "DELETE from from PROCEDURE p where p.id = ?1", nativeQuery = true)
    public void deleteByID(String id);

}
