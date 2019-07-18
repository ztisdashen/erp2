package com.web.action;

import com.biz.ISupplierBiz;
import com.entity.Supplier;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:14
 **/
public class SupplierAction extends ActionSupport implements ModelDriven<Supplier> {
    private Supplier supplier = new Supplier();
    @Override
    public Supplier getModel() {
        return supplier;
    }

    private ISupplierBiz supplierBiz;

    public void setSupplierBiz(ISupplierBiz supplierBiz) {
        this.supplierBiz = supplierBiz;
    }
    private Integer page;
    private Integer rows;
    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}