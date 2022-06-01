package ca.me.proj.api.service.base;

import java.util.List;
import ca.me.proj.api.dtos.base.BaseDTO;

public interface IBaseService<D extends BaseDTO, PK> {

        public abstract boolean existsById(PK id);

        public abstract List<D> findAll();

        public abstract D findById(PK entityId);

        public abstract D save(D dto);

        public abstract List<D> save(Iterable<D> dtos);

        public abstract D update(D dto);

        public abstract List<D> update(Iterable<D> dtos);

        public abstract boolean deleteById(PK id);

}
