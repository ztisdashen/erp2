package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IRoleBiz;
import com.entity.Role;
import com.entity.Role;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:13
 **/
public class RoleAction extends BaseAction<Role> implements ModelDriven<Role> {
    private Role role = new Role();
    @Override
    public Role getModel() {
        setT(role);
        return role;
    }
    private IRoleBiz roleBiz;

    public void setRoleBiz(IRoleBiz roleBiz) {
        setBaseBiz(roleBiz);
        this.roleBiz = roleBiz;
    }
    public String delete() {
        try {
            Role t1 = roleBiz.findById(role.getUuid());
            roleBiz.delete(t1);
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
        Role byId = roleBiz.findById(role.getUuid());
        String jsonString = JSON.toJSONString(byId);
        response(jsonString);
        return NONE;
    }
}