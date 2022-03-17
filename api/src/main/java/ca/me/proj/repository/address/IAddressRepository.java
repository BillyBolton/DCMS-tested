package ca.me.proj.repository.address;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.address.AddressEntity;
import ca.me.proj.entity.address.AddressId;

@Repository
public interface IAddressRepository extends CrudRepository<AddressEntity, AddressId> {

    @Override
    @Query(value = "SELECT * from ADDRESS", nativeQuery = true)
    public List<AddressEntity> findAll();


}
