package com.biz.impl;

import com.biz.IDepBiz;
import com.dao.IDepDao;
import com.entity.Dep;

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
