package ca.me.proj.mapper.authentication;

import ca.me.proj.dtos.authentication.AuthenticationDTO;
import ca.me.proj.entity.authentication.AuthenticationEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-10T11:33:29-0500",
    comments = "version: 1.4.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.13 (Eclipse Adoptium)"
)
@Component
public class IAuthenticationMapperImpl implements IAuthenticationMapper {

    @Override
    public AuthenticationDTO entityToDto(AuthenticationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AuthenticationDTO authenticationDTO = new AuthenticationDTO();

        authenticationDTO.setId( entity.getId() );
        authenticationDTO.setUsername( entity.getUsername() );
        authenticationDTO.setPassword( entity.getPassword() );

        return authenticationDTO;
    }

    @Override
    public AuthenticationEntity dtoToEntity(AuthenticationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AuthenticationEntity authenticationEntity = new AuthenticationEntity();

        authenticationEntity.setId( dto.getId() );
        authenticationEntity.setUsername( dto.getUsername() );
        authenticationEntity.setPassword( dto.getPassword() );

        return authenticationEntity;
    }

    @Override
    public List<AuthenticationEntity> dtoToEntity(Iterable<AuthenticationDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<AuthenticationEntity> list = new ArrayList<AuthenticationEntity>();
        for ( AuthenticationDTO authenticationDTO : dtos ) {
            list.add( dtoToEntity( authenticationDTO ) );
        }

        return list;
    }

    @Override
    public List<AuthenticationDTO> entityToDto(Iterable<AuthenticationEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AuthenticationDTO> list = new ArrayList<AuthenticationDTO>();
        for ( AuthenticationEntity authenticationEntity : entities ) {
            list.add( entityToDto( authenticationEntity ) );
        }

        return list;
    }
}
