package com.web.action;

import com.biz.IReturnOrderDetailBiz;
import com.biz.IReturnorderBiz;
import com.entity.Returnorderdetail;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:12
 **/
public class ReturnOrderDetailAction extends ActionSupport implements ModelDriven<Returnorderdetail> {
    private Returnorderdetail returnorderdetail = new Returnorderdetail();
    @Override
    public Returnorderdetail getModel() {
        return returnorderdetail;
    }
    private IReturnOrderDetailBiz returnOrderDetailBiz;

    public void setReturnOrderDetailBiz(IReturnOrderDetailBiz returnOrderDetailBiz) {
        this.returnOrderDetailBiz = returnOrderDetailBiz;
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