package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IOrdersBiz;

import com.entity.Orders;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:11
 **/
public class OrdersAction extends BaseAction<Orders> implements ModelDriven<Orders> {
    private Orders orders = new Orders();
    @Override
    public Orders getModel() {
        setT(orders);
        return orders;
    }
    private IOrdersBiz ordersBiz;

    public void setOrdersBiz(IOrdersBiz ordersBiz) {
        setBaseBiz(ordersBiz);
        this.ordersBiz = ordersBiz;
    }
    public String delete() {
        try {
            Orders t1 = ordersBiz.findById(orders.getUuid());
            ordersBiz.delete(t1);
            ajaxReturn("msg", "删除成功");
        } catch (Exception e) {
            ajaxReturn("msg", "删除失败");
        }
        return NONE;

    }

    /**
     * 回显数据
     *
     * @return
     */
    public String edit() {
        Orders byId = ordersBiz.findById(orders.getUuid());
        String jsonString = JSON.toJSONString(byId);
        respone(jsonString);
        return NONE;
    }
}