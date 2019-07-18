package com.web.action;

import com.biz.IStoreBiz;
import com.entity.Store;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:13
 **/
public class StoreAction extends ActionSupport implements ModelDriven<Store> {
    private Store store = new Store();
    @Override
    public Store getModel() {
        return store;
    }
    private IStoreBiz storeBiz;

    public void setStoreBiz(IStoreBiz storeBiz) {
        this.storeBiz = storeBiz;
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