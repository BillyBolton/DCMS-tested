package ca.me.proj.entity.authentication;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuthenticationEntity is a Querydsl query type for AuthenticationEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuthenticationEntity extends EntityPathBase<AuthenticationEntity> {

    private static final long serialVersionUID = -325129167L;

    public static final QAuthenticationEntity authenticationEntity = new QAuthenticationEntity("authenticationEntity");

    public final ca.me.proj.rest.components.entity.base.QAbstractBaseEntity _super = new ca.me.proj.rest.components.entity.base.QAbstractBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath password = createString("password");

    public final StringPath username = createString("username");

    public QAuthenticationEntity(String variable) {
        super(AuthenticationEntity.class, forVariable(variable));
    }

    public QAuthenticationEntity(Path<? extends AuthenticationEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthenticationEntity(PathMetadata metadata) {
        super(AuthenticationEntity.class, metadata);
    }

}

