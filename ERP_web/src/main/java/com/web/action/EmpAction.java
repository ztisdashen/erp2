package com.web.action;

import com.biz.IEmpBiz;
import com.entity.Emp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:08
 **/
public class EmpAction extends ActionSupport implements ModelDriven<Emp> {
    private Emp emp = new Emp();
    @Override
    public Emp getModel() {
        return emp;
    }
    private IEmpBiz empBiz;

    public void setEmpBiz(IEmpBiz empBiz) {
        this.empBiz = empBiz;
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
