package com.web.action;

import com.biz.IStoredetailBiz;
import com.entity.Storedetail;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:13
 **/
public class StoreDetailAction extends ActionSupport implements ModelDriven<Storedetail> {
    private Storedetail storedetail = new Storedetail();
    @Override
    public Storedetail getModel() {
        return storedetail;
    }
    private IStoredetailBiz storedetailBiz;

    public void setStoredetailBiz(IStoredetailBiz storedetailBiz) {
        this.storedetailBiz = storedetailBiz;
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