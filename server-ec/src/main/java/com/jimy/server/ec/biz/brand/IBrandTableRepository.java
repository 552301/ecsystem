package com.jimy.server.ec.biz.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @ClassName:  BrandTableRepository
 * @Description:TODO(品牌 dao)
 * @author: jimy
 * @create: 2019年3月25日
 * @version: 1.0.0
 */

public interface IBrandTableRepository extends JpaRepository<BrandTable, Long>, JpaSpecificationExecutor<BrandTable> {

}