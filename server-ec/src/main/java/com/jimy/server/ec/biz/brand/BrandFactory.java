package com.jimy.server.ec.biz.brand;

import com.jimy.ec.core.base.factory.BaseFactory;

/**
 * 〈一句话功能简述〉
 * 〈品牌工厂类〉
 *
 * @author jimy
 * @create 2019/3/22
 * @since 1.0.0
 */
public class BrandFactory extends BaseFactory<BrandTable,BrandEntity> {
    public BrandFactory(Class<BrandTable> clazz, Class<BrandEntity> mClazz) {
        super(clazz, mClazz);
    }
}
