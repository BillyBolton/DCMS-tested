package ca.me.proj.mapper.profile;

import java.util.List;
import org.mapstruct.Mapper;
import ca.me.proj.dtos.profile.ProfileDTO;
import ca.me.proj.entity.profile.ProfileEntity;

@Mapper
public interface IProfileMapper {
    ProfileDTO entityToDto(ProfileEntity entity);

    ProfileEntity dtoToEntity(ProfileDTO dto);

    List<ProfileEntity> dtoToEntity(Iterable<ProfileDTO> dtos);

    List<ProfileDTO> entityToDto(Iterable<ProfileEntity> entities);
    
}
