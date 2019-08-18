package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IEmpBiz;
import com.entity.Emp;
import com.entity.Emp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.Date;

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
    private Emp emp2;
    public String resetPWD(){
        Emp tmpEmp = empBiz.findById(emp.getUuid());
        tmpEmp.setPwd(emp.getPwd());
        try{
            empBiz.updateResetPWD(tmpEmp);
            ajaxReturn(true,"重置成功");
        }catch (Exception e){
            e.printStackTrace();
            ajaxReturn(false,"重置失败");
        }

        return NONE;

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
        String jsonString = JSON.toJSONStringWithDateFormat(byId,"yyyy-MM-dd");
        response(jsonString);
        return NONE;
    }

    @Override
    public String editFinal() {
        try {
            empBiz.updateResetPWD(emp);
            ajaxReturn("msg","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            ajaxReturn("msg","修改失败");
        }
        return NONE;
    }

    public void setEmp2(Emp emp2) {
        super.setT2(emp2);
        this.emp2 = emp2;
    }
}
