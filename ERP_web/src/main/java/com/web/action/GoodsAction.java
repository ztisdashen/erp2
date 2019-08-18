package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IGoodsBiz;
import com.entity.Goods;
import com.entity.Goods;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:10
 **/
public class GoodsAction extends BaseAction<Goods> implements ModelDriven<Goods> {
    private Goods goods = new Goods();
    private Goods goods2;

    @Override
    public Goods getModel() {
        super.setT(goods);
        return goods;
    }
    private IGoodsBiz goodsBiz;

    public void setGoodsBiz(IGoodsBiz goodsBiz) {
        super.setBaseBiz(goodsBiz);
        this.goodsBiz = goodsBiz;
    }
    public String delete() {
        try {
            Goods t1 = goodsBiz.findById(goods.getUuid());
            goodsBiz.delete(t1);
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
        Goods byId = goodsBiz.findById(goods.getUuid());
        String jsonString = JSON.toJSONString(byId);
        response(jsonString);
        return NONE;
    }

    public void setGoods2(Goods goods2) {
        super.setT2(goods2);
        this.goods2 = goods2;
    }
}