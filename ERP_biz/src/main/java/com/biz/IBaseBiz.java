package com.biz;


import com.entity.Page;


public interface IBaseBiz<T> {


    Page<T> findByPage(T t, Integer page, Integer rows);

    void add(T t);

    void delete(T t);

    T findById(long uuid);

    void edit(T t);
}
