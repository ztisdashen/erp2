package com.biz;

import com.entity.Emp;
import com.entity.Orderdetail;
import com.entity.Orders;

public interface IOrderdetailBiz extends IBaseBiz<Orderdetail> {
    void doInStore(Orderdetail orderdetail, Long empUUID);
}
