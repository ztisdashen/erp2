package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IStoreoperBiz;
import com.entity.Storeoper;
import com.entity.Storeoper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:14
 **/
public class StoreoperAction extends BaseAction<Storeoper> implements ModelDriven<Storeoper> {
    private Storeoper storeoper = new Storeoper();
    @Override
    public Storeoper getModel() {
        return storeoper;
    }
    private IStoreoperBiz storeoperBiz;

    public void setStoreoperBiz(IStoreoperBiz storeoperBiz) {
        this.storeoperBiz = storeoperBiz;
    }
    public String delete() {
        try {
            Storeoper t1 = storeoperBiz.findById(storeoper.getUuid());
            storeoperBiz.delete(t1);
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
        Storeoper byId = storeoperBiz.findById(storeoper.getUuid());
        String jsonString = JSON.toJSONString(byId);
        respone(jsonString);
        return NONE;
    }
}