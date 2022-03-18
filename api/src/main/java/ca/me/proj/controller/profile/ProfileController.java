package ca.me.proj.controller.profile;

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
import ca.me.proj.dtos.profile.AuthenticationDTO;
import ca.me.proj.dtos.profile.ProfileDTO;
import ca.me.proj.service.profile.ProfileService;


@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService service;

    @PostMapping("/authenticate")
    public boolean authenticate(@RequestBody AuthenticationDTO credentials) {

        return service.authenticate(credentials);
    }

    @GetMapping("/findAll")
    public List<ProfileDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/findByUsername")
    public ProfileDTO findbyUsername(@RequestParam String username) {
        return service.findByUsername(username);
    }

    @GetMapping("/existsByUsername")
    public boolean existsByUsername(@RequestParam String username) {
        return service.existsByUsername(username);
    }

    @GetMapping("/existsByID")
    public boolean existsByID(@RequestParam String id) {
        return service.existsByID(id);
    }


    @PostMapping("/create")
    public ResponseEntity<String> createProfile(@RequestBody ProfileDTO profileDTO) {
        ResponseEntity<String> response = service.createProfile(profileDTO);
        return response;
    }

    @DeleteMapping("/deleteByUsername")
    public ProfileDTO deleteUserbyUsername(@RequestParam String username) {
        ProfileDTO profileDTO = service.deleteUserbyUsername(username);
        return profileDTO;
    }

}
