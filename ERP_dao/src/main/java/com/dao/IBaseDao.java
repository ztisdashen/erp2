package com.dao;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface IBaseDao<T> {
    void add(T t);
    void delete(T t);
    void edit(T t);
    T findById(Long uuid);
    int getCount(DetachedCriteria criteria);
    List<T> findByPage(DetachedCriteria criteria, int begin, Integer rows);

    List<T> findAll();
}
