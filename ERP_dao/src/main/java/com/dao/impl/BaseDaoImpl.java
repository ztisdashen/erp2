package com.dao.impl;

import com.dao.IBaseDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 12:58
 **/
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

    private Class<T> aClass;
    public BaseDaoImpl(){

        //当她被继承后后，this就是比如DepDaoImpl，getGenericSuperclass得到就是带有参数化泛型的BaseDaoImpl<>
        Type superclass = this.getClass().getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) superclass;
        //得到参数化的泛型
        Type[] types = type.getActualTypeArguments();
        this.aClass = (Class) types[0];
    }
    @Override
    public void add(T t) {
        this.getHibernateTemplate().save(t);
    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    @Override
    public void edit(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public T findById(Long uuid) {
        return  this.getHibernateTemplate().get(aClass,uuid);
    }

    @Override
    public int getCount(DetachedCriteria criteria) {
        criteria.setProjection(Projections.rowCount());
        List<Long> longs = (List<Long>) this.getHibernateTemplate().findByCriteria(criteria);
        return longs.get(0).intValue();
    }

    @Override
    public List<T> findByPage(DetachedCriteria criteria, int begin, Integer rows) {
        criteria.setProjection(null);

        return (List<T>) this.getHibernateTemplate().findByCriteria(criteria,begin,rows);
    }
}
