package com.jimy.ec.core.base.biz;

import com.jimy.ec.core.base.common.PageBean;
import com.jimy.ec.core.base.common.Wrapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * 〈一句话功能简述〉
 * 〈biz基类〉
 *
 * @author jimy
 * @create 2019/3/19
 * @since 1.0.0
 */
public interface IBaseBiz<T,M>  {
    /**
     * 保存和更新数据
     * @param bean
     */
    void save(M bean);

    /**
     * 保存数据
     * @param bean
     */
    void insert(M bean);

    /**
     * 更新数据
     * @param bean
     */
    void update(M bean);

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
     * 这个用于执行删除和更新的sql语句
     *
     * @param sql
     * @param params
     */
    int executeSql(String sql, Object... params);

    /**
     * 这个用于执行删除和更新的hql语句
     * @param hql
     * @param params
     */
    int executeHql(String hql, Object... params);

    /**
     * 根据原始sql语句执行sql
     * @param sql    原始sql语句
     * @param params 要传递的参数
     * @return map对象
     */
    List<Map<String, Object>> findSql(String sql, Object... params);

    /**
     * @param sql    原始sql语句
     * @param clazz  要反射的Class对象
     * @param params 要传递的参数
     * @param <T>
     * @return
     */
    <T> List<T> findSql(String sql, Class<T> clazz, Object... params);

    /**
     * 执行原始sql并返回Object[]集合
     * @param sql
     * @param params
     * @return
     */
    List<Object[]> findObjectSql(String sql, Object... params);

    /**
     * 分页显示数据
     *
     * @param sql
     * @param pageNum  第几页
     * @param pageSize 每页显示多少个
     * @param params   需要传递的参数
     * @return
     */
    PageBean<Map<String,Object>> pageSql(String sql, Integer pageNum, Integer pageSize, Object... params);

    /**
     * 分页显示数据
     * @param sql
     * @param clazz
     * @param pageNum
     * @param pageSize
     * @param params
     * @param <T2>
     * @return
     */
    <T2> PageBean<T2> pageSql(String sql,Class<T2> clazz,int pageNum,int pageSize,Object... params);

    /**
     * 分页查询
     * @param sql
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    PageBean<Object[]> pageObjectSql(String sql, int pageNum, int pageSize, Object... params);

    /**
     * 执行hql查询语句
     * @param hql
     * @param params
     * @return
     */
    <T2> List<T2> findHql(String hql,Class<T2> clazz, Object... params);

    /**
     * hql语句返回Object[]对象
     * @param hql
     * @param params
     * @return
     */
    List<Object[]> findObjectHql(String hql, Object... params);

    /**
     * 分页查询
     * @param hql hql语句 (注意hql中的未知参数用？表 selec p from Teacher p where p.name = ?)
     * @param clazz 要查询的对象可以是自定义类型也可是java中自定义类型比如String
     * @param pageNum 第几页
     * @param pageSize 每页显示多少数据
     * @param params hql中需要的参数
     * @param <T2>
     * @return
     */
    <T2> PageBean<T2> pageHql(String hql, Class<T2> clazz, Integer pageNum, Integer pageSize, Object... params);


    /**
     *hql执行统计总数
     * @param hql
     * @param params
     * @return
     */
    Long countHql(String hql, Object... params);

    /**
     * 执行统计总数
     * @param sql
     * @param params
     * @return
     */
    Long countSql(String sql, Object... params);

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

    /**
     * 获取一条记录方法
     * @param hql
     * @param clazz
     * @param <T2>
     * @return
     */
    <T2> T2 findOneHql(String hql, Class<T2> clazz, Object... params);

    /**
     * 返回小于等于一条结果时
     * @param sql
     * @param clazz
     * @param <T2>
     * @return
     */
    <T2> T2 findOneSql(String sql, Class<T2> clazz, Object... params);


    List<Map<String,Object>> findWrapper(Wrapper wrapper);

    <T2> List<T2> findWrapper(Wrapper wrapper,Class<T2> clazz);
}
