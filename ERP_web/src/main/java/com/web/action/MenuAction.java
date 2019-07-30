package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IMenuBiz;
import com.entity.Menu;
import com.entity.Menu;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:11
 **/
public class MenuAction extends BaseAction<Menu> implements ModelDriven<Menu> {
    private Menu menu = new Menu();
    @Override
    public Menu getModel() {
        setT(menu);
        return menu;
    }
    private IMenuBiz menuBiz;

    public void setMenuBiz(IMenuBiz menuBiz) {
        setBaseBiz(menuBiz);
        this.menuBiz = menuBiz;
    }

}