package com.biz;


import com.entity.Page;

import java.util.List;


public interface IBaseBiz<T> {


    Page<T> findByPage(T t,T t2, Integer page, Integer rows);

    void add(T t);

    void delete(T t);

    T findById(long uuid);
    T findById(String uuid);
    void edit(T t);

    List<T> findAll(T t);
}
