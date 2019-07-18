package com.biz.impl;

import com.Utils;
import com.biz.IDepBiz;
import com.dao.IDepDao;
import com.dao.impl.BaseDaoImpl;
import com.entity.Dep;
import com.entity.Page;
import org.hibernate.criterion.DetachedCriteria;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 部门业务的实现
 *
 * @program: ERP
 * @description:
 * @author: zt648
 * @create: 2019-07-17 11:41
 **/
public class DepBizImpl extends BaseBizImpl<Dep> implements IDepBiz {
    private IDepDao dao;


    public void setDao(IDepDao dao) {
        super.setBaseDao(dao);
        this.dao = dao;
    }


}
