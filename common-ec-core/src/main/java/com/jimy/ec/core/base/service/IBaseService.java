package com.jimy.ec.core.base.service;

import com.jimy.ec.core.base.common.PageBean;
import com.jimy.ec.core.base.common.Wrapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * 〈一句话功能简述〉
 * 〈基础service〉
 *
 * @author jimy
 * @create 2019/3/19
 * @since 1.0.0
 */
public interface IBaseService<T,M> {
    /**
     * 保存或者更新
     * @param bean
     * @return
     */
    int save(M bean);

    /**
     * 保存
     * @param bean
     * @return
     */
    int insert(M bean);

    /**
     * 更新数据
     * @param bean
     */
    int update(M bean);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    M findOne(Serializable id);

    /**
     * 根据id删除制定数据
     * @param id
     * @return
     */
    int delete(Serializable id);

    /**
     * 查询所有数据
     * @return
     */
    List<M> findAll();

    /**
     * 分页显示数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<M> pageList(int pageNum, int pageSize);

    /**
     * 查询所有并按主键降序
     * @return
     */
    List<M> findAllDesc();

    /**
     * 分页显示并按主键降序
     * @return
     */
    List<M> pageListDesc(int pageNum, int pageSize);

    /**
     * 对指定字段降序排序
     * @param fieldName
     * @return
     */
    List<M> findAllDesc(String fieldName);

    /**
     * 安某个字段并查找指定数据个数
     * @param fielName
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<M> pageListDesc(String fielName, int pageNum, int pageSize);

    /**
     * 查询所有并按主键升序
     * @return
     */
    List<M> findAllAsc();

    /**
     * 查找指定数量并按主键升序
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<M> pageListAsc(int pageNum, int pageSize);

    /**
     * 对指定字段升序排序
     * @param fieldName
     * @return
     */
    List<M> findAllAsc(String fieldName);

    /**
     * 对指定字段降序并查询指定数量
     * @param fieldName
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<M> pageListAsc(String fieldName, int pageNum, int pageSize);

    /**
     * 批量保存
     * @param beans
     */
    void batchSave(List<M> beans);

    /**
     * 批量更新所有字段
     * @param beans
     */
    void batchUpdate(List<M> beans);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDelete(List<? extends Serializable> ids);

    /**
     * 批量更新非空字段
     * @param beans
     */
    void batchUpdateNotNull(List<M> beans);

    /**
     * 更新非空字段
     * @param bean
     * @return
     */
    int updateNotNull(M bean);

    /**
     * 根据字段删除数据
     * @param field
     * @param value
     * @return
     */
    int deleteEqualField(String field, Object value);

    /**
     * like匹配删除
     * @param field
     * @param value
     * @return
     */
    int deleteLikeField(String field, String value);

    /**
     * 相等查找
     * @param field 字段名
     * @param value 字段对应的值
     * @return
     */
    List<M> findEqualField(String field, Object value);

    /**
     * like匹配查找
     * @param field 字段名
     * @param value 字段对应的值
     * @return
     */
    List<M> findLikeField(String field, String value);

    /**
     * 根据字段进行between查询
     * @param field
     * @param start
     * @param end
     * @return
     */
    List<M> findBetweenField(String field, Object start, Object end);

    /**
     * 删除所有
     */
    int deleteAll();

    /**
     * 对bean对象的多个字段and的equal匹配
     * @param data
     * @return
     */
    List<M> findAndFields(Map<String, Object> data);

    /**
     * 对bean对象多个字段or的equal匹配
     * @param data
     * @return
     */
    List<M> findOrFields(Map<String, Object> data);

    List<M> listBetweenField(String fieldName, Object start, Object end);

    List<M> listLikeField(String fieldName, String value);

    List<M> listEqualField(String fieldName, Object value);

    List<M> listAll();

    void batchAdd(List<M> datas);

    List<?> findWrapper(Wrapper wrapper);

    <T2> List<T2> findWrapper(Wrapper wrapper,Class<T2> clazz);
}
