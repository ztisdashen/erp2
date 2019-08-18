package com.biz.impl;

import com.biz.Utils;
import com.biz.IBaseBiz;
import com.dao.IBaseDao;
import com.entity.Page;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 15:26
 **/
public class BaseBizImpl<T> implements IBaseBiz<T>, Serializable {

    private IBaseDao<T> baseDao;


    public void setBaseDao(IBaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public Page<T> findByPage(T t,T t2, Integer page, Integer rows) {
        Page<T> page1 = new Page<>();
        page1.setCurrentPage(page);
        page1.setPageSize(rows);
        DetachedCriteria criteria = null;
        try {
            criteria = Utils.getDetachedCriteria(t, t.getClass());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        int totalCount = baseDao.getCount(criteria);
        int totalPage = totalCount % rows == 0 ? totalCount / rows : (totalCount / rows) + 1;
        int begin = (page - 1) * rows;
        List<T> list = baseDao.findByPage(criteria, begin, rows);
        page1.setTotalPage(totalPage);
        page1.setTotalSize(totalCount);
        page1.setList(list);
        return page1;
    }

    @Override
    public void add(T t) {
        baseDao.add(t);
    }

    @Override
    public void delete(T t) {
        baseDao.delete(t);
    }

    @Override
    public T findById(long uuid) {
        return baseDao.findById(uuid);
    }

    @Override
    public T findById(String uuid) {
        return baseDao.findById(uuid);
    }

    @Override
    public void edit(T t) {
        baseDao.edit(t);
    }

    @Override
    public List<T> findAll(T t) {
        return baseDao.findAll(t);
    }
}
