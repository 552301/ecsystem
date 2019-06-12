package com.jimy.server.ec.api.service.impl;

import com.jimy.ec.core.base.service.BaseServiceImpl;
import com.jimy.server.ec.api.service.IBrandService;
import com.jimy.server.ec.biz.brand.BrandEntity;
import com.jimy.server.ec.biz.brand.BrandTable;
import com.jimy.server.ec.biz.brand.IBrandBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉
 * 〈品牌service接口实现类〉
 *
 * @author jimy
 * @create 2019/3/22
 * @since 1.0.0
 */
@Service
public class BrandServiceImpl extends BaseServiceImpl<IBrandBiz,BrandTable, BrandEntity> implements IBrandService {

    @Autowired
    private IBrandBiz brandBiz;
    @Override
    public boolean existsById(Long id) {
        return brandBiz.existsById(id);
    }

    @Override
    public Long countAll() {
        return brandBiz.countAll();
    }
}
