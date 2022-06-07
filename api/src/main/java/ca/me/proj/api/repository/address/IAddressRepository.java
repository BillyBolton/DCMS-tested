package ca.me.proj.api.repository.address;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.constants.province.Province;
import ca.me.proj.api.entity.address.AddressEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IAddressRepository extends IBaseRepository<AddressEntity, String> {


        public AddressEntity findByBuildingNumberAndStreetAndCityAndProvinceAndPostalCode(
                        long buildingNumber, String street, String city, Province province,
                        String postalCode);

        public boolean existsByBuildingNumberAndStreetAndCityAndProvinceAndPostalCode(
                        long buildingNumber, String street, String city, Province province,
                        String postalCode);

}
