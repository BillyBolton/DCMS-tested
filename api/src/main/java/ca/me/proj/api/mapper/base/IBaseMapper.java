package ca.me.proj.api.mapper.base;

import java.util.List;
import ca.me.proj.api.dtos.base.BaseDTO;
import ca.me.proj.api.entity.base.AbstractBaseEntity;

public interface IBaseMapper<D extends BaseDTO, E extends AbstractBaseEntity> {

    D entityToDto(E entity);

    E dtoToEntity(D dto);

    List<E> dtoToEntity(Iterable<D> dtos);

    List<D> entityToDto(Iterable<E> entities);

}
