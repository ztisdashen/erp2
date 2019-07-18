package com.web.action;

import com.biz.IEmpRoleBiz;
import com.entity.EmpRole;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:09
 **/
public class EmpRoleAction extends ActionSupport implements ModelDriven<EmpRole> {
    private EmpRole empRole = new EmpRole();
    @Override
    public EmpRole getModel() {
        return empRole;
    }

    private IEmpRoleBiz empRoleBiz;

    public void setEmpRoleBiz(IEmpRoleBiz empRoleBiz) {
        this.empRoleBiz = empRoleBiz;
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