package com.web.action;

import com.biz.IStoreoperBiz;
import com.entity.Storeoper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:14
 **/
public class StoreoperAction extends ActionSupport implements ModelDriven<Storeoper> {
    private Storeoper storeoper = new Storeoper();
    @Override
    public Storeoper getModel() {
        return storeoper;
    }
    private IStoreoperBiz storeoperBiz;

    public void setStoreoperBiz(IStoreoperBiz storeoperBiz) {
        this.storeoperBiz = storeoperBiz;
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