package ca.me.proj.repository.address;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.address.AddressEntity;

@Repository
public interface IAddressRepository extends JpaRepository<AddressEntity, String> {

        @Query(value = "SELECT CASE WHEN count(a)> 0 THEN true ELSE false end from ADDRESS a where a.id = ?1",
                        nativeQuery = true)
        public boolean existsByID(String id);

        @Query(value = "SELECT CASE WHEN count(a)> 0 THEN true ELSE false end from ADDRESS a where (a.building_number = ?1 and a.street = ?2 and a.city = ?3 and a.province = ?4 and a.postal_code = ?5)",
                        nativeQuery = true)
        public boolean existsByAddress(long buildingNumber, String street, String city,
                        String province, String postalCode);

        @Override
        @Query(value = "SELECT * from ADDRESS", nativeQuery = true)
        public List<AddressEntity> findAll();

        @Query(value = "SELECT * from ADDRESS WHERE id = ?1 ", nativeQuery = true)
        public <Optional> AddressEntity findByID(String id);

        @Query(value = "SELECT * from ADDRESS a WHERE (a.building_number = ?1 and a.street = ?2 and a.city = ?3 and a.province = ?4 and a.postal_code = ?5) ",
                        nativeQuery = true)
        public <Optional> AddressEntity findByAddress(long buildingNumber, String street,
                        String city, String province, String postalCode);

        @Query(value = "DELETE from ADDRESS a where a.id = ?1", nativeQuery = true)
        public void deleteByID(String id);



}
