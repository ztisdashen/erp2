package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IOrdersBiz;

import com.entity.Emp;
import com.entity.Orderdetail;
import com.entity.Orders;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import javax.persistence.Tuple;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:11
 **/
public class OrdersAction extends BaseAction<Orders> implements ModelDriven<Orders> {
    private Orders orders = new Orders();
    private IOrdersBiz ordersBiz;
    private String json;

    @Override
    public Orders getModel() {
        setT(orders);
        return orders;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public void setOrdersBiz(IOrdersBiz ordersBiz) {
        setBaseBiz(ordersBiz);
        this.ordersBiz = ordersBiz;
    }

    public String delete() {
        try {
            Orders t1 = ordersBiz.findById(orders.getUuid());
            ordersBiz.delete(t1);
            ajaxReturn("msg", "删除成功");
        } catch (Exception e) {
            ajaxReturn("msg", "删除失败");
        }
        return NONE;

    }


    public String add() {
        try {

            List<Orderdetail> orderdetails = JSON.parseArray(json, Orderdetail.class);
            orders.setOrderdetails(orderdetails);
            Emp emp = (Emp) ActionContext.getContext().getSession().get("loginUser");
            //session 是否已经超时
            if (emp == null) {
                ajaxReturn(false, "未登录");
                return NONE;
            }
            orders.setCreater(emp.getUuid());
            ordersBiz.add(orders);
            ajaxReturn(true, "提交成功");
        } catch (Exception e) {
            e.printStackTrace();
            ajaxReturn(false, "提交失败");
        }

        return NONE;
    }

    /**
     * 回显数据
     *
     * @return
     */
    public String edit() {
        Orders byId = ordersBiz.findById(orders.getUuid());
        String jsonString = JSON.toJSONString(byId);
        response(jsonString);
        return NONE;
    }
}