package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.ISupplierBiz;
import com.entity.Supplier;
import com.entity.Supplier;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:14
 **/
public class SupplierAction extends BaseAction<Supplier> implements ModelDriven<Supplier> {
    private Supplier supplier = new Supplier();
    @Override
    public Supplier getModel() {
        setT(supplier);
        return supplier;
    }

    private ISupplierBiz supplierBiz;

    public void setSupplierBiz(ISupplierBiz supplierBiz) {
        setBaseBiz(supplierBiz);
        this.supplierBiz = supplierBiz;
    }
    public String delete() {
        try {
            Supplier t1 = supplierBiz.findById(supplier.getUuid());
            supplierBiz.delete(t1);
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
        Supplier byId = supplierBiz.findById(supplier.getUuid());
        String jsonString = JSON.toJSONString(byId);
        respone(jsonString);
        return NONE;
    }
}