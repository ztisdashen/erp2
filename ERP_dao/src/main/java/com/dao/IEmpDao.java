package com.dao;

import com.entity.Emp;

public interface IEmpDao extends IBaseDao<Emp>{

    Emp findByNameAndPassWord(Emp emp);
}
