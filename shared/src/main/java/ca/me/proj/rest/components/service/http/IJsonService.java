package ca.me.proj.rest.components.service.http;

import java.util.List;
import ca.me.proj.rest.components.dtos.base.BaseDTO;

public interface IJsonService<D extends BaseDTO> {

    public abstract List<D> findAll();

}
