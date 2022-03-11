package ca.me.proj.mapper.authentication;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ca.me.proj.dtos.authentication.AuthenticationDTO;
import ca.me.proj.entity.authentication.AuthenticationEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper
public interface IAuthenticationMapper
        extends IBaseMapper<AuthenticationDTO, AuthenticationEntity> {

    @Override
    @Mapping(source = "id", target = "auth_id")
    AuthenticationDTO entityToDto(AuthenticationEntity entity);

}
