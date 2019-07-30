package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IReturnorderBiz;
import com.entity.Returnorders;
import com.entity.Returnorders;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:12
 **/
public class ReturnOrdersAction extends BaseAction<Returnorders> implements ModelDriven<Returnorders> {
    private Returnorders returnorders = new Returnorders();

    @Override
    public Returnorders getModel() {
        setT(returnorders);
        return returnorders;
    }

    private IReturnorderBiz returnorderBiz;

    public void setReturnorderBiz(IReturnorderBiz returnorderBiz) {
        setBaseBiz(returnorderBiz);
        this.returnorderBiz = returnorderBiz;
    }

    public String delete() {
        try {
            Returnorders t1 = returnorderBiz.findById(returnorders.getUuid());
            returnorderBiz.delete(t1);
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
        Returnorders byId = returnorderBiz.findById(returnorders.getUuid());
        String jsonString = JSON.toJSONString(byId);
        respone(jsonString);
        return NONE;
    }
}