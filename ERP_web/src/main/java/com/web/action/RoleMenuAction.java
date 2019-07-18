package com.web.action;

import com.biz.IRoleMenuBiz;
import com.entity.RoleMenu;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:13
 **/
public class RoleMenuAction extends ActionSupport implements ModelDriven<RoleMenu> {
    private RoleMenu roleMenu = new RoleMenu();
    @Override
    public RoleMenu getModel() {
        return roleMenu;
    }
    private IRoleMenuBiz roleMenuBiz;

    public void setRoleMenuBiz(IRoleMenuBiz roleMenuBiz) {
        this.roleMenuBiz = roleMenuBiz;
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