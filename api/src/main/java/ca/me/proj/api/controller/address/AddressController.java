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
@RequestMapping("/address")
public class AddressController extends AbstractCrudController<AddressDTO, AddressEntity, String> {

    @Autowired
    private AddressService addressService;

    // @GetMapping("/findAll")
    // public List<AddressDTO> findAll() {
    // return service.findAll();
    // }

    // @GetMapping("/existsByID")
    // public boolean existsByID(@RequestParam String id) {
    // return service.existsByID(id);
    // }

    // @GetMapping("/findByID")
    // public AddressDTO findByID(@RequestParam String id) {
    // return service.findByID(id);
    // }

    // @PostMapping("/create")
    // public AddressDTO create(@RequestBody AddressDTO dto) {
    // return service.create(dto);
    // }

    // @DeleteMapping("/deleteByID")
    // public void deleteByID(@RequestParam String id) {
    // service.deleteById(id);
    // }

    // @PutMapping("/update")
    // public AddressDTO update(@RequestBody AddressDTO dto) {
    // return service.update(dto);
    // }

    @PostMapping("/findBy/address")
    public AddressDTO findByAddress(@RequestBody AddressDTO dto) {
        return addressService.findByAddress(dto);
    }
}
