package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IEmpBiz;
import com.entity.Emp;
import com.entity.Emp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:08
 **/
public class EmpAction extends BaseAction<Emp> implements ModelDriven<Emp> {
    private Emp emp = new Emp();
    @Override
    public Emp getModel() {
        super.setT(emp);
        return emp;
    }
    private IEmpBiz empBiz;

    public void setEmpBiz(IEmpBiz empBiz) {
        super.setBaseBiz(empBiz);
        this.empBiz = empBiz;
    }
    public String delete() {
        try {
            Emp t1 = empBiz.findById(emp.getUuid());
            empBiz.delete(t1);
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
        Emp byId = empBiz.findById(emp.getUuid());
        String jsonString = JSON.toJSONString(byId);
        respone(jsonString);
        return NONE;
    }
}
