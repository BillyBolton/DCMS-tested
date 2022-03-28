package ca.me.proj.repository.address;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.address.AddressEntity;

@Repository
public interface IAddressRepository extends CrudRepository<AddressEntity, String> {

    @Override
    @Query(value = "SELECT * from ADDRESS", nativeQuery = true)
    public List<AddressEntity> findAll();

    @Override
    @Query(value = "SELECT CASE WHEN count(a)> 0 THEN true ELSE false end from ADDRESS a where a.id = ?1", nativeQuery = true)
    public boolean existsById(String id);
    

    @Query(value = "SELECT * from ADDRESS WHERE id = ?1 ", nativeQuery = true)
    public <Optional>AddressEntity findByID(String id);


}
