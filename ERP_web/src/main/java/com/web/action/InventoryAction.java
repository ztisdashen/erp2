package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IInventoryBiz;
import com.entity.Inventory;
import com.entity.Inventory;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:10
 **/
public class InventoryAction extends BaseAction<Inventory> implements ModelDriven<Inventory> {
    private Inventory inventory = new Inventory();
    @Override
    public Inventory getModel() {
        return inventory;
    }
    private IInventoryBiz inventoryBiz;

    public void setInventoryBiz(IInventoryBiz inventoryBiz) {
        this.inventoryBiz = inventoryBiz;
    }
    public String delete() {
        try {
            Inventory t1 = inventoryBiz.findById(inventory.getUuid());
            inventoryBiz.delete(t1);
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
        Inventory byId = inventoryBiz.findById(inventory.getUuid());
        String jsonString = JSON.toJSONString(byId);
        response(jsonString);
        return NONE;
    }
}