package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IEmpRoleBiz;
import com.entity.EmpRole;
import com.entity.EmpRole;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:09
 **/
public class EmpRoleAction extends BaseAction<EmpRole> implements ModelDriven<EmpRole> {
    private EmpRole empRole = new EmpRole();
    @Override
    public EmpRole getModel() {
        super.setT(empRole);
        return empRole;
    }

    private IEmpRoleBiz empRoleBiz;

    public void setEmpRoleBiz(IEmpRoleBiz empRoleBiz) {
        super.setBaseBiz(empRoleBiz);
        this.empRoleBiz = empRoleBiz;
    }
    public String delete() {
        try {
            EmpRole t1 = empRoleBiz.findById(empRole.getUuid());
            empRoleBiz.delete(t1);
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
        EmpRole byId = empRoleBiz.findById(empRole.getUuid());
        String jsonString = JSON.toJSONString(byId);
        respone(jsonString);
        return NONE;
    }
}