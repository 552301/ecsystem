package com.jimy.server.ec.biz;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QECBaseTable is a Querydsl query type for ECBaseTable
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QECBaseTable extends EntityPathBase<ECBaseTable> {

    private static final long serialVersionUID = 2045208377L;

    public static final QECBaseTable eCBaseTable = new QECBaseTable("eCBaseTable");

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final StringPath createName = createString("createName");

    public final DateTimePath<java.util.Date> updateDate = createDateTime("updateDate", java.util.Date.class);

    public final StringPath updateName = createString("updateName");

    public QECBaseTable(String variable) {
        super(ECBaseTable.class, forVariable(variable));
    }

    public QECBaseTable(Path<? extends ECBaseTable> path) {
        super(path.getType(), path.getMetadata());
    }

    public QECBaseTable(PathMetadata metadata) {
        super(ECBaseTable.class, metadata);
    }

}

