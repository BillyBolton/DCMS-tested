package ca.me.proj.controller.address;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.address.AddressDTO;
import ca.me.proj.service.address.AddressService;


@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping("/findAll")
    public List<AddressDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/existsByID")
    public boolean existsByID(@RequestParam String id) {
        return service.existsByID(id);
    }

    @GetMapping("/findByID")
    public AddressDTO findByID(@RequestParam String id) {
        return service.findByID(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAddress(@RequestBody AddressDTO dto) {
        return service.createAddress(dto);
    }
    
    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteAddressbyId(@RequestParam String id) {
        return service.deleteAddressbyId(id);
    }

}
