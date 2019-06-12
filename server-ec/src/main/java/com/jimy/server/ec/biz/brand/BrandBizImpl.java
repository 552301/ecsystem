package com.jimy.server.ec.biz.brand;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.jimy.ec.core.base.biz.BaseBizImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 〈一句话功能简述〉
 * 〈品牌biz接口实现类〉
 *
 * @author jimy
 * @create 2019/3/22
 * @since 1.0.0
 */
@Component
public class BrandBizImpl extends BaseBizImpl<BrandTable,BrandEntity> implements IBrandBiz {

    @Autowired
    protected IBrandTableRepository brandTableRepository;

    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public boolean existsById(Long id) {
        return brandTableRepository.existsById(id);
    }

    @Override
    public Long countAll() {
        return brandTableRepository.count();
    }

    @Override
    public String findBrandNameById(Long brandId) {
        QBrandTable brandTable = QBrandTable.brandTable;
        return queryFactory.selectFrom(brandTable)
                .where(brandTable.brandId.eq(brandId))
                .select(brandTable.brandName)
                .fetchOne().toString();
    }
}
