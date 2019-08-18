package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IReturnOrderDetailBiz;
import com.biz.IReturnorderBiz;
import com.entity.Returnorderdetail;
import com.entity.Returnorderdetail;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:12
 **/
public class ReturnOrderDetailAction extends BaseAction<Returnorderdetail> implements ModelDriven<Returnorderdetail> {
    private Returnorderdetail returnorderdetail = new Returnorderdetail();
    @Override
    public Returnorderdetail getModel() {
        setT(returnorderdetail);
        return returnorderdetail;
    }
    private IReturnOrderDetailBiz returnOrderDetailBiz;

    public void setReturnOrderDetailBiz(IReturnOrderDetailBiz returnOrderDetailBiz) {
        setBaseBiz(returnOrderDetailBiz);
        this.returnOrderDetailBiz = returnOrderDetailBiz;
    }
    public String delete() {
        try {
            Returnorderdetail t1 = returnOrderDetailBiz.findById(returnorderdetail.getUuid());
            returnOrderDetailBiz.delete(t1);
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
        Returnorderdetail byId = returnOrderDetailBiz.findById(returnorderdetail.getUuid());
        String jsonString = JSON.toJSONString(byId);
        response(jsonString);
        return NONE;
    }
}