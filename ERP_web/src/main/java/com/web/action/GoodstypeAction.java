package com.web.action;

//import com.dao.IGoodstype;
import com.biz.IGoodstypeBiz;
import com.entity.Goodstype;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:10
 **/
public class GoodstypeAction extends ActionSupport implements ModelDriven<Goodstype> {
    private Goodstype goodstype = new Goodstype();
    @Override
    public Goodstype getModel() {
        return goodstype;
    }
    private IGoodstypeBiz goodstypeBiz;

    public void setGoodstypeBiz(IGoodstypeBiz goodstypeBiz) {
        this.goodstypeBiz = goodstypeBiz;
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