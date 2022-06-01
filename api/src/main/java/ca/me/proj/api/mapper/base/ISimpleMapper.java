package ca.me.proj.api.mapper.base;

import org.mapstruct.Mapping;
import ca.me.proj.api.dtos.base.BaseDTO;
import ca.me.proj.api.entity.base.AbstractBaseEntity;

public interface ISimpleMapper<D extends BaseDTO, E extends AbstractBaseEntity>
        extends IBaseMapper<D, E> {

    @Override
    @Mapping(source = "id", target = "entityId")
    D entityToDto(E entity);

    @Override
    @Mapping(source = "entityId", target = "id")
    E dtoToEntity(D dto);

}
