package ca.me.proj.mapper.authentication;

import org.mapstruct.Mapper;
import ca.me.proj.dtos.authentication.AuthenticationDTO;
import ca.me.proj.entity.authentication.AuthenticationEntity;
import ca.me.proj.mapper.base.ISimpleMapper;

@Mapper
public interface IAuthenticationMapper
        extends ISimpleMapper<AuthenticationDTO, AuthenticationEntity> {

}
