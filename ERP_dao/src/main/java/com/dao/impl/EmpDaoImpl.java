package com.dao.impl;

import com.dao.IEmpDao;
import com.entity.Emp;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.hibernate.criterion.DetachedCriteria;

import java.io.PrintWriter;
import java.util.List;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 18:04
 **/
public class EmpDaoImpl extends BaseDaoImpl<Emp> implements IEmpDao {
    private static final int HASH_ITERATION = 2;
    @Override
    public Emp findByNameAndPassWord(Emp emp) {
        List<Emp> emps = this.getHibernateTemplate().findByExample(emp);
        if(emps.size()>0)
            return emps.get(0);
        return null;
    }



}
