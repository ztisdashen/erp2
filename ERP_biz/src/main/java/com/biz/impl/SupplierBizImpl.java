package com.biz.impl;

import com.biz.ISupplierBiz;
import com.dao.ISupplierDao;
import com.entity.Supplier;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 19:47
 **/
public class SupplierBizImpl extends BaseBizImpl<Supplier> implements ISupplierBiz {
    private ISupplierDao supplierDao;

    public void setSupplierDao(ISupplierDao supplierDao) {
        super.setBaseDao(supplierDao);
        this.supplierDao = supplierDao;
    }
}
