package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IStoreBiz;
import com.entity.Emp;
import com.entity.Store;
import com.entity.Store;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:13
 **/
public class StoreAction extends BaseAction<Store> implements ModelDriven<Store> {
    private Store store = new Store();
    @Override
    public Store getModel()
    {
        super.setT(store);
        return store;
    }
    private IStoreBiz storeBiz;

    @Override
    public String listAll() {
        Emp emp = (Emp) ActionContext.getContext().getSession().get("loginUser");
        if(emp == null){
            response(null);
            return NONE;
        }


        store.setEmpuuid(emp.getUuid());
        return super.listAll();
    }

    public void setStoreBiz(IStoreBiz storeBiz) {
        super.setBaseBiz(storeBiz);
        this.storeBiz = storeBiz;
    }
    public String delete() {
        try {
            Store t1 = storeBiz.findById(store.getUuid());
            storeBiz.delete(t1);
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
        Store byId = storeBiz.findById(store.getUuid());
        String jsonString = JSON.toJSONString(byId);
        response(jsonString);
        return NONE;
    }
}