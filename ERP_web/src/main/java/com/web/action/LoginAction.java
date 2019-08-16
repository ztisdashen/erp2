package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IEmpBiz;
import com.entity.Emp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.Else;

import javax.persistence.Tuple;
import javax.servlet.http.HttpServletResponse;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-30 15:17
 **/
public class LoginAction extends ActionSupport implements ModelDriven<Emp> {
    private Emp emp = new Emp();
    private IEmpBiz empBiz;
    private String oldPassword;
    private String newPassword;

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public Emp getModel() {
        return emp;
    }

    public void setEmpBiz(IEmpBiz empBiz) {
        this.empBiz = empBiz;
    }

    public String checkUser(){
        try {
            Emp emp = empBiz.findByNameAndPwd(this.emp);
            System.out.println(emp.getPwd());
            if(emp!=null){
                ActionContext.getContext().getSession().put("loginUser",emp);
                ajaxReturn(true,"登陆成功");
            } else{
                ajaxReturn(false,"用户名或密码错误");
            }
        }catch (Exception e){
            ajaxReturn(false,"登陆失败");
        }

        return NONE;
    }


    public String loginOut(){
        ActionContext.getContext().getSession().remove("loginUser");

        return NONE;
    }

    public void ajaxReturn(Object msg, Object info) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", msg);
        map.put("msg",info);
        String jsonString = JSON.toJSONString(map);
        response(jsonString);
    }

    public void response(String jsonString) {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String showName(){
        Emp emp = (Emp) ActionContext.getContext().getSession().get("loginUser");
        //session 是否已经超时
        if (emp!=null)
            ajaxReturn(true,emp.getName());
        else
            ajaxReturn(false,"");
        return NONE;
    }

    public String updatePwd(){
        System.out.println(newPassword+" "+oldPassword);
        Emp emp = (Emp) ActionContext.getContext().getSession().get("loginUser");
        if(emp == null){
            ajaxReturn(false,"请重新登录");
        }else {
            try{
                empBiz.updatePWD(emp,newPassword,oldPassword);
                ajaxReturn(true,"修改密码成功");
            }catch (Exception e){
                e.printStackTrace();
                ajaxReturn(false,"修改密码失败");
            }
        }
        return NONE;
    }
}
