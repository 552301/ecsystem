package com.jimy.server.ec.api.service;

import com.jimy.ec.core.base.service.IBaseService;
import com.jimy.server.ec.biz.brand.BrandEntity;
import com.jimy.server.ec.biz.brand.BrandTable;

/**
 * 〈一句话功能简述〉
 * 〈品牌service接口〉
 *
 * @author jimy
 * @create 2019/3/22
 * @since 1.0.0
 */
public interface IBrandService extends IBaseService<BrandTable, BrandEntity> {
    boolean existsById(Long id);

    /**
     *  功能描述:
     * 〈统计所有品牌行数〉
     * @param
     * @return: Long
     * @since:  1.0.0
     * @Author: jimy
     * @Date:   2019年3月25日
     */
    Long countAll();
}
