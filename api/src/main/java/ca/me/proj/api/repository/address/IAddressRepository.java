package ca.me.proj.api.repository.address;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.constants.province.Province;
import ca.me.proj.api.entity.address.AddressEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IAddressRepository extends IBaseRepository<AddressEntity, String> {

        // @Query(value = "SELECT CASE WHEN count(a)> 0 THEN true ELSE false end from ADDRESS a
        // where a.id = ?1",
        // nativeQuery = true)
        // public boolean existsByID(String id);

        // @Query(value = "SELECT CASE WHEN count(a)> 0 THEN true ELSE false end from ADDRESS a
        // where (a.building_number = ?1 and a.street = ?2 and a.city = ?3 and a.province = ?4 and
        // a.postal_code = ?5)",
        // nativeQuery = true)
        // public boolean existsByAddress(long buildingNumber, String street, String city,
        // String province, String postalCode);

        // @Override
        // @Query(value = "SELECT * from ADDRESS", nativeQuery = true)
        // public List<AddressEntity> findAll();

        // @Query(value = "SELECT * from ADDRESS WHERE id = ?1 ", nativeQuery = true)
        // public <Optional> AddressEntity findByID(String id);

        // @Query(value = "SELECT * from ADDRESS a WHERE (a.building_number = ?1 and a.street = ?2
        // and a.city = ?3 and a.province = ?4 and a.postal_code = ?5) ",
        // nativeQuery = true)
        // public <Optional> AddressEntity findByAddress(long buildingNumber, String street,
        // String city, String province, String postalCode);

        public AddressEntity findByBuildingNumberAndStreetAndCityAndProvinceAndPostalCode(
                        long buildingNumber, String street, String city, Province province,
                        String postalCode);

        public boolean existsByBuildingNumberAndStreetAndCityAndProvinceAndPostalCode(
                        long buildingNumber, String street, String city, Province province,
                        String postalCode);

        // @Modifying
        // @Query(value = "DELETE from ADDRESS a where a.id = ?1", nativeQuery = true)
        // public void deleteByID(String id);



}
