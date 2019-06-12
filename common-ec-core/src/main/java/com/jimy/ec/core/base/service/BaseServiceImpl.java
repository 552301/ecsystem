package com.jimy.ec.core.base.service;

import com.jimy.ec.core.base.biz.IBaseBiz;
import com.jimy.ec.core.base.common.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈service基类实现〉
 *
 * @author jimy
 * @create 2019/3/19
 * @since 1.0.0
 */
public class BaseServiceImpl<N extends IBaseBiz<T,M>,T,M> implements IBaseService<T,M> {
    @Autowired
    protected N  baseBiz;

    @Override
    public int save(M bean) {
        try {
            baseBiz.save(bean);
            return 1;
        }catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int insert(M bean) {
        try {
            baseBiz.insert(bean);
            return 1;
        }catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int update(M bean) {
        try {
            baseBiz.update(bean);
            return 1;
        }catch (Exception e) {
            return -1;
        }
    }

    @Override
    public M findOne(Serializable id) {
        return baseBiz.findOne(id);
    }

    @Override
    public int delete(Serializable id) {
        return baseBiz.delete(id);
    }

    @Override
    public List<M> findAll() {
        return baseBiz.findAll();
    }

    @Override
    public int batchDelete(List<? extends Serializable> ids) {
        return baseBiz.batchDelete(ids);
    }

    @Override
    public void batchUpdateNotNull(List<M> beans) {
        baseBiz.batchUpdateNotNull(beans);
    }

    @Override
    public int updateNotNull(M bean) {
        return baseBiz.updateNotNull(bean);
    }

    @Override
    public int deleteEqualField(String field, Object value) {
        return baseBiz.deleteEqualField(field, value);
    }

    @Override
    public int deleteLikeField(String field, String value) {
        return baseBiz.deleteLikeField(field, value);
    }

    @Override
    public List<M> findEqualField(String field, Object value) {
        return baseBiz.findEqualField(field, value);
    }

    @Override
    public List<M> findLikeField(String field, String value) {
        return baseBiz.findLikeField(field, value);
    }

    @Override
    public List<M> findBetweenField(String field, Object start, Object end) {
        return baseBiz.findBetweenField(field, start, end);
    }

    @Override
    public int deleteAll() {
        return baseBiz.deleteAll();
    }

    @Override
    public List<M> findAndFields(Map<String, Object> data) {
        return baseBiz.findAndFields(data);
    }

    @Override
    public List<M> findOrFields(Map<String, Object> data) {
        return baseBiz.findOrFields(data);
    }

    @Override
    public void batchAdd(List<M> datas) {
        baseBiz.batchSave(datas);
    }

    @Override
    public void batchUpdate(List<M> datas) {
        baseBiz.batchUpdate(datas);
    }

    @Override
    public List<M> listAll() {
        return baseBiz.findAll();
    }

    @Override
    public List<M> pageList(int pageNum, int pageSize) {
        return baseBiz.pageList(pageNum,pageSize);
    }

    @Override
    public List<M> findAllDesc() {
        return baseBiz.findAllDesc();
    }

    @Override
    public List<M> pageListDesc(int pageNum, int pageSize) {
        return baseBiz.pageListDesc(pageNum, pageSize);
    }

    @Override
    public List<M> findAllDesc(String fieldName) {
        return baseBiz.findAllDesc(fieldName);
    }

    @Override
    public List<M> pageListDesc(String fielName, int pageNum, int pageSize) {
        return baseBiz.pageListDesc(fielName, pageNum, pageSize);
    }

    @Override
    public List<M> findAllAsc() {
        return baseBiz.findAllAsc();
    }

    @Override
    public List<M> pageListAsc(int pageNum, int pageSize) {
        return baseBiz.pageListAsc(pageNum, pageSize);
    }

    @Override
    public List<M> findAllAsc(String fieldName) {
        return baseBiz.findAllAsc(fieldName);
    }

    @Override
    public List<M> pageListAsc(String fieldName, int pageNum, int pageSize) {
        return baseBiz.pageListAsc(fieldName, pageNum, pageSize);
    }

    @Override
    public void batchSave(List<M> beans) {
        baseBiz.batchSave(beans);
    }

    @Override
    public List<M> listEqualField(String fieldName, Object value) {
        return baseBiz.findEqualField(fieldName,value);
    }

    @Override
    public List<M> listLikeField(String fieldName, String value) {
        return baseBiz.findLikeField(fieldName,value);
    }

    @Override
    public List<M> listBetweenField(String fieldName, Object start, Object end) {
        return baseBiz.findBetweenField(fieldName,start,end);
    }

    @Override
    public List<?> findWrapper(Wrapper wrapper) {
        return baseBiz.findWrapper(wrapper);
    }

    @Override
    public <T2> List<T2> findWrapper(Wrapper wrapper, Class<T2> clazz) {
        return baseBiz.findWrapper(wrapper,clazz);
    }
}
