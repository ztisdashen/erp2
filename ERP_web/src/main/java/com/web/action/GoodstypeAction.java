package com.web.action;

//import com.dao.IGoodstype;
import com.alibaba.fastjson.JSON;
import com.biz.IGoodstypeBiz;
import com.entity.Goodstype;
import com.entity.Goodstype;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 20:10
 **/
public class GoodstypeAction extends BaseAction<Goodstype> implements ModelDriven<Goodstype> {
    private Goodstype goodstype = new Goodstype();
    @Override
    public Goodstype getModel() {
        setT(goodstype);
        return goodstype;
    }
    private IGoodstypeBiz goodstypeBiz;

    public void setGoodstypeBiz(IGoodstypeBiz goodstypeBiz) {
      setBaseBiz(goodstypeBiz);
        this.goodstypeBiz = goodstypeBiz;
    }
    public String delete() {
        try {
            Goodstype t1 = goodstypeBiz.findById(goodstype.getUuid());
            goodstypeBiz.delete(t1);
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
        Goodstype byId = goodstypeBiz.findById(goodstype.getUuid());
        String jsonString = JSON.toJSONString(byId);
        response(jsonString);
        return NONE;
    }
}