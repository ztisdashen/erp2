package com.biz.impl;

import com.biz.IStoreBiz;
import com.dao.IStoreDao;
import com.entity.Store;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 19:43
 **/
public class StoreBizImpl extends BaseBizImpl<Store>implements IStoreBiz {
    private IStoreDao storeDao;

    public void setStoreDao(IStoreDao storeDao) {
        super.setBaseDao(storeDao);
        this.storeDao = storeDao;
    }
}
