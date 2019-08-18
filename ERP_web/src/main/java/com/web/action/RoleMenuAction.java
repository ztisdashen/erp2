package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IRoleMenuBiz;
import com.entity.RoleMenu;
import com.entity.RoleMenu;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:13
 **/
public class RoleMenuAction extends BaseAction<RoleMenu> implements ModelDriven<RoleMenu> {
    private RoleMenu roleMenu = new RoleMenu();
    @Override
    public RoleMenu getModel() {
        setT(roleMenu);
        return roleMenu;
    }
    private IRoleMenuBiz roleMenuBiz;

    public void setRoleMenuBiz(IRoleMenuBiz roleMenuBiz) {
        setBaseBiz(roleMenuBiz);
        this.roleMenuBiz = roleMenuBiz;
    }
    public String delete() {
        try {
            RoleMenu t1 = roleMenuBiz.findById(roleMenu.getUuid());
            roleMenuBiz.delete(t1);
            ajaxReturn("msg", "删除成功");
        } catch (Exception e) {
            ajaxReturn("msg", "删除失败");
        }
        return NONE;

    }

    /**
     * 回显数据
     *
     * @return
     */
    public String edit() {
        RoleMenu byId = roleMenuBiz.findById(roleMenu.getUuid());
        String jsonString = JSON.toJSONString(byId);
        response(jsonString);
        return NONE;
    }
}