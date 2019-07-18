package com.web.action;

import com.biz.IOrdersBiz;
import com.entity.Orders;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:11
 **/
public class OrdersAction extends ActionSupport implements ModelDriven<Orders> {
    private Orders orders = new Orders();
    @Override
    public Orders getModel() {
        return orders;
    }
    private IOrdersBiz ordersBiz;

    public void setOrdersBiz(IOrdersBiz ordersBiz) {
        this.ordersBiz = ordersBiz;
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