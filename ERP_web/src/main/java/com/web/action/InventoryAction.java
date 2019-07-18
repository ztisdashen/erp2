package com.web.action;

import com.biz.IInventoryBiz;
import com.entity.Inventory;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:10
 **/
public class InventoryAction extends ActionSupport implements ModelDriven<Inventory> {
    private Inventory inventory = new Inventory();
    @Override
    public Inventory getModel() {
        return inventory;
    }
    private IInventoryBiz inventoryBiz;

    public void setInventoryBiz(IInventoryBiz inventoryBiz) {
        this.inventoryBiz = inventoryBiz;
    }
    private Integer page;
    private Integer rows;
    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}