package ca.me.proj.service.base;

import java.util.List;
import ca.me.proj.dtos.base.BaseDTO;

public interface IBaseService<D extends BaseDTO> {

        public abstract boolean existsByID(long id);

        public abstract List<D> findAll();

        public abstract D findByID(long entityId);

        public abstract D save(D dto);

        public abstract boolean delete(long id);

}
