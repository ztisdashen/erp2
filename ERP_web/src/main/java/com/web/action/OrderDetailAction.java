package com.web.action;

import com.biz.IOrderdetailBiz;
import com.entity.Orderdetail;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:11
 **/
public class OrderDetailAction extends ActionSupport implements ModelDriven<Orderdetail> {
    private Orderdetail orderdetail = new Orderdetail();
    @Override
    public Orderdetail getModel() {
        return orderdetail;
    }
    private IOrderdetailBiz orderdetailBiz;

    public void setOrderdetailBiz(IOrderdetailBiz orderdetailBiz) {
        this.orderdetailBiz = orderdetailBiz;
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