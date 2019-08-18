package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IStoredetailBiz;
import com.entity.Storedetail;
import com.entity.Storedetail;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:13
 **/
public class StoreDetailAction extends BaseAction<Storedetail> implements ModelDriven<Storedetail> {
    private Storedetail Storedetail = new Storedetail();
    @Override
    public Storedetail getModel() {
        setT(Storedetail);
        return Storedetail;
    }
    private IStoredetailBiz StoredetailBiz;

    public void setStoredetailBiz(IStoredetailBiz StoredetailBiz) {
        setBaseBiz(StoredetailBiz);
        this.StoredetailBiz = StoredetailBiz;
    }
    public String delete() {
        try {
            Storedetail t1 = StoredetailBiz.findById(Storedetail.getUuid());
            StoredetailBiz.delete(t1);
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
        Storedetail byId = StoredetailBiz.findById(Storedetail.getUuid());
        String jsonString = JSON.toJSONString(byId);
        response(jsonString);
        return NONE;
    }
}