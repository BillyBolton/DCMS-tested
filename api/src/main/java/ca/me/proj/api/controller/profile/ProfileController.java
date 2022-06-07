package ca.me.proj.api.controller.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.api.controller.base.AbstractCrudController;
import ca.me.proj.api.dtos.profile.AuthenticationDTO;
import ca.me.proj.api.dtos.profile.ProfileDTO;
import ca.me.proj.api.entity.profile.ProfileEntity;
import ca.me.proj.api.service.profile.ProfileService;


@RestController
@RequestMapping(ProfileUri.DOMAIN)
public class ProfileController extends AbstractCrudController<ProfileDTO, ProfileEntity, String> {

    @Autowired
    private ProfileService profileService;

    @PostMapping(ProfileUri.AUTHENTICATE)
    public boolean authenticate(@RequestBody AuthenticationDTO credentials) {
        return profileService.authenticate(credentials);
    }


    @GetMapping(ProfileUri.FIND_BY_USERNAME)
    public ProfileDTO findbyUsername(@RequestParam String username) {
        return profileService.findByUsername(username);
    }

    @GetMapping(ProfileUri.EXISTS_BY_USERNAME)
    public boolean existsByUsername(@RequestParam String username) {
        return profileService.existsByUsername(username);
    }

    // @PostMapping("/create")
    // public ProfileDTO create(@RequestBody ProfileDTO dto) {
    // return profileService.create(dto);
    // }

    @DeleteMapping(ProfileUri.DELETE_BY_USERNAME)
    public boolean deleteByUsername(@RequestParam String username) {
        return profileService.deleteByUsername(username);
    }


}
