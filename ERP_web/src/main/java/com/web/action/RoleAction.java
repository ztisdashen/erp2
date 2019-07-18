package com.web.action;

import com.biz.IRoleBiz;
import com.entity.Role;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:13
 **/
public class RoleAction extends ActionSupport implements ModelDriven<Role> {
    private Role role = new Role();
    @Override
    public Role getModel() {
        return role;
    }
    private IRoleBiz roleBiz;

    public void setRoleBiz(IRoleBiz roleBiz) {
        this.roleBiz = roleBiz;
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