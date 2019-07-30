package com.biz.impl;

import com.biz.IEmpBiz;
import com.biz.Utils;
import com.dao.IEmpDao;
import com.entity.Emp;
import com.entity.Page;
import org.hibernate.criterion.DetachedCriteria;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 18:45
 **/
public class EmpBizImpl extends BaseBizImpl<Emp> implements IEmpBiz {
    private IEmpDao empDao;

    public void setEmpDao(IEmpDao empDao) {
        super.setBaseDao(empDao);
        this.empDao = empDao;
    }

    @Override
    public Page<Emp> findByPage(Emp emp, Integer page, Integer rows) {

        Page<Emp> page1 = new Page<>();
        page1.setCurrentPage(page);
        page1.setPageSize(rows);
        DetachedCriteria criteria = DetachedCriteria.forClass(Emp.class);

        int totalCount = empDao.getCount(criteria);
        int totalPage = totalCount % rows == 0 ? totalCount / rows : (totalCount / rows) + 1;
        int begin = (page - 1) * rows;
        List<Emp> list = empDao.findByPage(criteria, begin, rows);
        page1.setTotalPage(totalPage);
        page1.setTotalSize(totalCount);
        page1.setList(list);
        return page1;
    }
}
