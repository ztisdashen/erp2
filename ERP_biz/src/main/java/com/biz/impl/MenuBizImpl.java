package com.biz.impl;

import com.biz.IMenuBiz;
import com.dao.IMenuDao;
import com.entity.Menu;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 18:50
 **/
public class MenuBizImpl extends BaseBizImpl<Menu> implements IMenuBiz {
    private IMenuDao menuDao;

    public void setMenuDao(IMenuDao menuDao) {
        super.setBaseDao(menuDao);
        this.menuDao = menuDao;
    }
}
