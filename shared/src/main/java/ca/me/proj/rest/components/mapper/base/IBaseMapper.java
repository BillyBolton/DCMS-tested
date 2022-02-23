package ca.me.proj.rest.components.mapper.base;

import java.util.List;

public interface IBaseMapper<D, E> {

    D entityToDto(E entity);

    E dtoToEntity(D dto);

    List<E> dtoToEntity(Iterable<D> dtos);

    List<D> entityToDto(Iterable<E> entities);

}
