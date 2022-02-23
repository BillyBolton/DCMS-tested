package ca.me.proj.mapper.authentication;

import org.mapstruct.Mapper;
import ca.me.proj.dtos.authentication.AuthenticationDTO;
import ca.me.proj.entity.authentication.AuthenticationEntity;
import ca.me.proj.rest.components.mapper.base.IBaseMapper;

@Mapper
public interface IAuthenticationMapper
        extends IBaseMapper<AuthenticationDTO, AuthenticationEntity> {

}
