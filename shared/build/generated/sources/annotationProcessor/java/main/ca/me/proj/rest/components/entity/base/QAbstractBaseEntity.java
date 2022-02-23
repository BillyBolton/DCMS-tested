package ca.me.proj.rest.components.entity.base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractBaseEntity is a Querydsl query type for AbstractBaseEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QAbstractBaseEntity extends EntityPathBase<AbstractBaseEntity> {

    private static final long serialVersionUID = 2091754065L;

    public static final QAbstractBaseEntity abstractBaseEntity = new QAbstractBaseEntity("abstractBaseEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QAbstractBaseEntity(String variable) {
        super(AbstractBaseEntity.class, forVariable(variable));
    }

    public QAbstractBaseEntity(Path<? extends AbstractBaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractBaseEntity(PathMetadata metadata) {
        super(AbstractBaseEntity.class, metadata);
    }

}

