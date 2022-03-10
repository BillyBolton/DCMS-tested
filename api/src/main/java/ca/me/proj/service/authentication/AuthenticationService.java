package ca.me.proj.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.authentication.AuthenticationDTO;
import ca.me.proj.entity.authentication.AuthenticationEntity;
import ca.me.proj.mapper.authentication.IAuthenticationMapper;
import ca.me.proj.repository.authentication.IAuthenticationRepository;
import ca.me.proj.service.base.AbstractBaseServiceImpl;

@Service
public class AuthenticationService
        extends AbstractBaseServiceImpl<AuthenticationDTO, AuthenticationEntity> {

    @Autowired
    private IAuthenticationMapper mapper;

    @Autowired
    private IAuthenticationRepository repository;

}
