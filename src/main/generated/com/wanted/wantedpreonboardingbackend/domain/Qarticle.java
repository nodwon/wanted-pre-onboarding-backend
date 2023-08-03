package com.wanted.wantedpreonboardingbackend.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qarticle is a Querydsl query type for article
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qarticle extends EntityPathBase<article> {

    private static final long serialVersionUID = -1313892829L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qarticle article = new Qarticle("article");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public final QUserAccount userAccount;

    public Qarticle(String variable) {
        this(article.class, forVariable(variable), INITS);
    }

    public Qarticle(Path<? extends article> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qarticle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qarticle(PathMetadata metadata, PathInits inits) {
        this(article.class, metadata, inits);
    }

    public Qarticle(Class<? extends article> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userAccount = inits.isInitialized("userAccount") ? new QUserAccount(forProperty("userAccount")) : null;
    }

}

