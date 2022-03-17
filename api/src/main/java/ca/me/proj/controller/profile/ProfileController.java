package ca.me.proj.controller.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.profile.ProfileDTO;
import ca.me.proj.service.profile.ProfileService;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/findAll")
    public List<ProfileDTO> findAll() {
        return profileService.findAll();
    }

    @GetMapping("/findByUsername")
    public ProfileDTO findbyUsername(@RequestParam String username){
        return profileService.findByUsername(username);
    }

    @GetMapping("/existsByUsername")
    public boolean existsByUsername(@RequestParam String username){
        return profileService.existsByUsername(username);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProfile( @RequestBody ProfileDTO profileDTO ){
        ResponseEntity<String> response = profileService.createProfile(profileDTO);
        return response;
    }

    @DeleteMapping("/deleteByUsername")
    public ProfileDTO deleteUserbyUsername(@RequestParam String username){
        ProfileDTO profileDTO = profileService.deleteUserbyUsername(username);
        return profileDTO;
    }
    
}
