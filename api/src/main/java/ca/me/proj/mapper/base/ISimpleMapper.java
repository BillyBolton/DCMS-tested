package ca.me.proj.mapper.base;

import org.mapstruct.Mapping;

public interface ISimpleMapper<D, E> extends IBaseMapper<D, E> {

    @Override
    @Mapping(source = "id", target = "entityId")
    D entityToDto(E entity);

    @Override
    @Mapping(source = "entityId", target = "id")
    E dtoToEntity(D dto);

}
