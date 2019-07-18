package com.web.action;

import com.biz.IGoodsBiz;
import com.entity.Goods;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:10
 **/
public class GoodsAction extends ActionSupport implements ModelDriven<Goods> {
    private Goods goods = new Goods();
    @Override
    public Goods getModel() {
        return goods;
    }
    private IGoodsBiz goodsBiz;

    public void setGoodsBiz(IGoodsBiz goodsBiz) {
        this.goodsBiz = goodsBiz;
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