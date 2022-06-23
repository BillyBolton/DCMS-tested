package ca.me.proj.api.controller.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.api.controller.base.AbstractCrudController;
import ca.me.proj.api.dtos.address.AddressDTO;
import ca.me.proj.api.entity.address.AddressEntity;
import ca.me.proj.api.service.address.AddressService;


@RestController
@RequestMapping(AddressUri.DOMAIN)
public class AddressController extends AbstractCrudController<AddressDTO, AddressEntity, String> {

    @Autowired
    private AddressService addressService;

    @PostMapping(AddressUri.FIND_BY_ADDRESS)
    public AddressDTO findByAddress(@RequestBody AddressDTO dto) {
        return addressService.findByAddress(dto);
    }
}
