package ca.me.proj.rest.components.service.base;

import java.util.List;
import ca.me.proj.rest.components.dtos.base.BaseDTO;

public interface IBaseService<D extends BaseDTO> {

        public abstract boolean existsById(long id);

        public abstract List<D> findAll();

        public abstract D findById(long entityId);

        public abstract D save(D dto);

        public abstract boolean delete(long id);

}
