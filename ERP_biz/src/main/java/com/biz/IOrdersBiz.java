package com.biz;

import com.entity.Orders;

public interface IOrdersBiz extends IBaseBiz<Orders> {
    void doCheck(Orders orders,Long empUuid);
    void doStart(Orders orders,Long empUUID);
}
