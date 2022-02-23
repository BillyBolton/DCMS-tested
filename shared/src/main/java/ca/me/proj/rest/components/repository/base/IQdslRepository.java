package ca.me.proj.rest.components.repository.base;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IQdslRepository<E> extends IBaseRepository<E>, QuerydslPredicateExecutor<E> {

}
