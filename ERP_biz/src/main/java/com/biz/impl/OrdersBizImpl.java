package com.biz.impl;

import com.biz.IOrdersBiz;
import com.dao.IEmpDao;
import com.dao.IOrdersDao;
import com.dao.ISupplierDao;
import com.entity.*;
import com.exception.ERPException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 18:52
 **/
public class OrdersBizImpl extends BaseBizImpl<Orders> implements IOrdersBiz {
    private IOrdersDao ordersDao;
    private IEmpDao empDao;
    private ISupplierDao supplierDao;

    public void setEmpDao(IEmpDao empDao) {
        this.empDao = empDao;
    }

    public void setSupplierDao(ISupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

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
            total += orderdetail.getMoney();
            orderdetail.setState(Orderdetail.STATE_NOT_IN);
            orderdetail.setOrders(orders);
        }
        orders.setTotalmoney(total);
        super.add(orders);
    }

    @Override
    public Page<Orders> findByPage(Orders orders, Orders t2, Integer page, Integer rows) {
        Page<Orders> ordersPage = super.findByPage(orders, t2, page, rows);
        Map<Long, String> empNameMap = new HashMap<>();
        Map<Long, String> supplierNameMap = new HashMap<>();
        for (Orders tmpOrders : ordersPage.getList()) {
            tmpOrders.setCreaterName(getEmpName(empNameMap, tmpOrders.getCreater()));
            tmpOrders.setStarterName(getEmpName(empNameMap, tmpOrders.getStarter()));
            tmpOrders.setCheckerName(getEmpName(empNameMap, tmpOrders.getChecker()));
            tmpOrders.setEnderName(getEmpName(empNameMap, tmpOrders.getEnder()));
            tmpOrders.setSupplierName(getSuplierName(supplierNameMap, tmpOrders.getSupplieruuid()));
        }
        return ordersPage;
    }

    private String getEmpName(Map<Long, String> empNameMap, Long uuid) {
        if (uuid == null)
            return null;
        String createrName = empNameMap.get(uuid);
        if (createrName == null) {
            Emp emp = empDao.findById(uuid);
            empNameMap.put(uuid, emp.getName());
            return emp.getName();
        }
        return createrName;
    }

    private String getSuplierName(Map<Long, String> supplierNameMap, Long uuid) {
        if (uuid == null)
            return null;
        String createrName = supplierNameMap.get(uuid);
        if (createrName == null) {
            Supplier emp = supplierDao.findById(uuid);
            supplierNameMap.put(uuid, emp.getName());
            return emp.getName();
        }
        return createrName;
    }

    @Override
    public void doCheck(Orders orders, Long empUuid) {
        Orders tmpOrders = ordersDao.findById(orders.getUuid());
        if (!tmpOrders.getState().equals(Orders.STATE_CREATE)) {
            throw new ERPException("已经审核");
        }

        tmpOrders.setState(Orders.STATE_CHECK);
        tmpOrders.setChecktime(new Date());
        tmpOrders.setChecker(empUuid);
        ordersDao.update(tmpOrders);
    }

    @Override
    public void doStart(Orders orders, Long empUUID) {
        Orders tmpOrders = ordersDao.findById(orders.getUuid());
        if (!tmpOrders.getState().equals(Orders.STATE_CHECK)) {
            throw new ERPException("已经确认");
        }

        tmpOrders.setState(Orders.STATE_START);
        tmpOrders.setStarttime(new Date());
        tmpOrders.setStarter(empUUID);
        ordersDao.update(tmpOrders);
    }
}
