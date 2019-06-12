package com.jimy.server.ec.biz.brand;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBrandTable is a Querydsl query type for BrandTable
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBrandTable extends EntityPathBase<BrandTable> {

    private static final long serialVersionUID = -2045729036L;

    public static final QBrandTable brandTable = new QBrandTable("brandTable");

    public final com.jimy.server.ec.biz.QECBaseTable _super = new com.jimy.server.ec.biz.QECBaseTable(this);

    public final StringPath brandCode = createString("brandCode");

    public final NumberPath<Long> brandId = createNumber("brandId", Long.class);

    public final StringPath brandName = createString("brandName");

    public final StringPath brandNote = createString("brandNote");

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    //inherited
    public final StringPath createName = _super.createName;

    //inherited
    public final DateTimePath<java.util.Date> updateDate = _super.updateDate;

    //inherited
    public final StringPath updateName = _super.updateName;

    public QBrandTable(String variable) {
        super(BrandTable.class, forVariable(variable));
    }

    public QBrandTable(Path<? extends BrandTable> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBrandTable(PathMetadata metadata) {
        super(BrandTable.class, metadata);
    }

}

