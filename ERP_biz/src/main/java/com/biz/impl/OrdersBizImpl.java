package com.biz.impl;

import com.biz.IOrdersBiz;
import com.dao.IOrdersDao;
import com.entity.Orderdetail;
import com.entity.Orders;

import java.util.Date;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 18:52
 **/
public class OrdersBizImpl extends BaseBizImpl<Orders>implements IOrdersBiz {
    private IOrdersDao ordersDao;

    public void setOrdersDao(IOrdersDao ordersDao) {
        super.setBaseDao(ordersDao);
        this.ordersDao = ordersDao;
    }

    @Override
    public void add(Orders orders) {
        orders.setState(Orders.STATE_CREATE);
        orders.setType(Orders.TYPE_IN);
        //下单时间
        orders.setCreatetime(new Date());
        double total = 0;
        for (Orderdetail orderdetail : orders.getOrderdetails()) {
            total +=orderdetail.getMoney();
            orderdetail.setState(Orderdetail.STATE_NOT_IN);
            orderdetail.setOrders(orders);
        }
        orders.setTotalmoney(total);
        super.add(orders);
    }
}
