package com.jimy.ec.core.base.factory;

import com.jimy.ec.core.utils.ObjectUtil;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈工厂类基类〉
 *
 * @author jimy
 * @create 2019/3/20
 * @since 1.0.0
 */
public class BaseFactory<T,M>{
    //设置需要检查的字段，值不能为空
    private final String CHECK_NULL_FIELDS="";

    private T t;
    private M m;

    public BaseFactory(Class<T> clazz,Class<M> mClazz){
        try {
            t = clazz.newInstance();
            m = mClazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 检查字段是否为空
     * @param vo
     */
//    public void checkNull(M vo){
//        ClassUtil.checkNull(vo, CHECK_NULL_FIELDS);
//    }

    /**
     * 检查字段是否为空
     * @param vos
     */
//    public void checkNull(List<M> vos) {
//        ClassUtil.checkNull(vos, CHECK_NULL_FIELDS);
//    }

    public T voToTable(M vo){
        T tab = t;
        if(vo != null)
            ObjectUtil.copyProperties(vo, tab);
        return tab;
    }

    public M tableToVo(T tab){
        M vo = m;
        if(tab != null)
            ObjectUtil.copyProperties(tab, vo);
        return vo;
    }

    public List<T> vosToTables(List<M> vos){
        List<T> tables = new ArrayList<>();
        if (vos == null || vos.isEmpty()) {
            return tables;
        }
        for(M vo : vos){
            tables.add(voToTable(vo));
        }
        return tables;
    }

    public List<M> tablesToVos(List<T> tables){
        List<M> vos = new ArrayList<>();
        if (tables == null || tables.isEmpty()) {
            return vos;
        }
        for(T tab : tables){
            vos.add(tableToVo(tab));
        }
        return vos;
    }

    public List<T> vosToTables(Page<M> vos){
        List<T> tables = new ArrayList<>();
        if (vos == null ) {
            return tables;
        }
        for(M vo : vos){
            tables.add(voToTable(vo));
        }
        return tables;
    }

    public List<M> tablesToVos(Page<T> tables){
        List<M> vos = new ArrayList<>();
        if (tables == null || tables.isEmpty()) {
            return vos;
        }
        for(T vo : tables){
            vos.add(tableToVo(vo));
        }
        return vos;
    }
}
