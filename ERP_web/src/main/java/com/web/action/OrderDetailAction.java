package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IOrderdetailBiz;
import com.entity.Emp;
import com.entity.Orderdetail;
import com.entity.Orderdetail;
import com.exception.ERPException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.swing.plaf.basic.BasicTreeUI;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:11
 **/
public class OrderDetailAction extends BaseAction<Orderdetail> implements ModelDriven<Orderdetail> {
    private Orderdetail orderdetail = new Orderdetail();
    @Override
    public Orderdetail getModel() {
        setT(orderdetail);
        return orderdetail;
    }
    private IOrderdetailBiz orderdetailBiz;

    public void setOrderdetailBiz(IOrderdetailBiz orderdetailBiz) {
        setBaseBiz(orderdetailBiz);
        this.orderdetailBiz = orderdetailBiz;
    }
    public String delete() {
        try {
            Orderdetail t1 = orderdetailBiz.findById(orderdetail.getUuid());
            orderdetailBiz.delete(t1);
            ajaxReturn("msg", "删除成功");
        } catch (Exception e) {
            ajaxReturn("msg", "删除失败");
        }
        return NONE;

    }


    public String doInStore(){
        Emp emp = (Emp) ActionContext.getContext().getSession().get("loginUser");
        if(emp == null){
            ajaxReturn(false,"还没登陆");
            return NONE;
        }
        try{
            orderdetailBiz.doInStore(orderdetail,emp.getUuid());
            ajaxReturn(true,"入库成功");
        }catch (ERPException e){
            ajaxReturn(false,e.getMessage());
        }catch (Exception e){
            ajaxReturn(false,"入库失败");
            e.printStackTrace();
        }

        return NONE;
    }
    /**
     * 回显数据
     *
     * @return
     */
    public String edit() {
        Orderdetail byId = orderdetailBiz.findById(orderdetail.getUuid());
        String jsonString = JSON.toJSONString(byId);
        response(jsonString);
        return NONE;
    }
}