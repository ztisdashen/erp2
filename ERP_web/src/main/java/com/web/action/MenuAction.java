package com.web.action;

import com.biz.IMenuBiz;
import com.entity.Menu;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:11
 **/
public class MenuAction extends ActionSupport implements ModelDriven<Menu> {
    private Menu menu = new Menu();
    @Override
    public Menu getModel() {
        return menu;
    }
    private IMenuBiz menuBiz;

    public void setMenuBiz(IMenuBiz menuBiz) {
        this.menuBiz = menuBiz;
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