package ca.me.proj.api.mapper.profile;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.api.dtos.profile.AuthenticationDTO;
import ca.me.proj.api.dtos.profile.ProfileDTO;
import ca.me.proj.api.entity.profile.ProfileEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProfileMapper extends IBaseMapper<ProfileDTO, ProfileEntity> {

    // ProfileDTO entityToDto(ProfileEntity entity);

    // ProfileEntity dtoToEntity(ProfileDTO dto);

    AuthenticationDTO profileDtoToAuthenticationDto(ProfileDTO authenticationDto);



}
