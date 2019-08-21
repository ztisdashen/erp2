package com.biz.impl;

import com.biz.IOrderdetailBiz;
import com.dao.IOrderdetailDao;
import com.dao.IStoreDao;
import com.dao.IStoredetailDao;
import com.dao.IStoreoperDao;
import com.entity.Orderdetail;
import com.entity.Orders;
import com.entity.Storedetail;
import com.entity.Storeoper;
import com.exception.ERPException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.core.io.Resource;

import java.util.Date;
import java.util.List;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 18:51
 **/
public class OrderdetailBizImpl extends BaseBizImpl<Orderdetail> implements IOrderdetailBiz {
    private IOrderdetailDao orderdetailDao;
    private IStoredetailDao storedetailDao;
    private IStoreoperDao storeoperDao;

    public void setStoredetailDao(IStoredetailDao storedetailDao) {
        this.storedetailDao = storedetailDao;
    }

    public void setStoreoperDao(IStoreoperDao storeoperDao) {
        this.storeoperDao = storeoperDao;
    }

    public void setOrderdetailDao(IOrderdetailDao orderdetailDao) {
        super.setBaseDao(orderdetailDao);
        this.orderdetailDao = orderdetailDao;
    }


    @Override
    public void doInStore(Orderdetail orderdetail, Long empUUID) {
        Orderdetail tmporderdetail = orderdetailDao.findById(orderdetail.getUuid());
        if (!tmporderdetail.getState().equals(Orderdetail.STATE_NOT_IN)) {
            throw new ERPException("不能重复入库");
        }
        tmporderdetail.setState(Orderdetail.STATE_IN);
        tmporderdetail.setEnder(empUUID);
        tmporderdetail.setEndtime(new Date());
        tmporderdetail.setStoreuuid(orderdetail.getStoreuuid());


        // *****更新库*****
        Storedetail storedetail = new Storedetail();
        storedetail.setGoodsuuid(orderdetail.getGoodsuuid());
        storedetail.setStoreuuid(orderdetail.getStoreuuid());
        List<Storedetail> all = storedetailDao.findAll(storedetail);
        if (all.size() > 0) {
            all.get(0).setNum(all.get(0).getNum() + tmporderdetail.getNum());
            storedetailDao.update(all.get(0));
        } else {
            storedetail.setNum(tmporderdetail.getNum());
            storedetailDao.add(storedetail);
        }
        Storeoper storeoper = new Storeoper();
        storeoper.setEmpuuid(empUUID);
        storeoper.setGoodsuuid(tmporderdetail.getGoodsuuid());
        storeoper.setOpertime(tmporderdetail.getEndtime());
        storeoper.setNum(tmporderdetail.getNum());
        storeoper.setStoreuuid(orderdetail.getStoreuuid());
        storeoper.setType(Storeoper.TYPE_IN);
        storeoperDao.add(storeoper);
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Orderdetail.class);
        Orders orders = tmporderdetail.getOrders();
        detachedCriteria.add(Restrictions.eq("orders", orders));
        detachedCriteria.add(Restrictions.eq("state", Orderdetail.STATE_NOT_IN));
        int count = orderdetailDao.getCount(detachedCriteria);
        if (count == 0) {
            //    所有的明细都入库了
            orders.setEnder(empUUID);
            orders.setState(Orders.STATE_END);
            orders.setEndtime(tmporderdetail.getEndtime());
        }


    }
}
