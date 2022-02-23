package ca.me.proj.controller.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.authentication.AuthenticationDTO;
import ca.me.proj.entity.authentication.AuthenticationEntity;
import ca.me.proj.rest.components.controller.base.AbstractReadWriteController;
import ca.me.proj.service.authentication.AuthenticationService;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController
        extends AbstractReadWriteController<AuthenticationDTO, AuthenticationEntity> {

    @Autowired
    private AuthenticationService service;

}
