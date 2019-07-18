package com.web.action;

import com.biz.IReturnorderBiz;
import com.entity.Returnorders;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:12
 **/
public class ReturnOrdersAction extends ActionSupport implements ModelDriven<Returnorders> {
    private Returnorders returnorders = new Returnorders();
    @Override
    public Returnorders getModel() {
        return returnorders;
    }
    private IReturnorderBiz returnorderBiz;

    public void setReturnorderBiz(IReturnorderBiz returnorderBiz) {
        this.returnorderBiz = returnorderBiz;
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