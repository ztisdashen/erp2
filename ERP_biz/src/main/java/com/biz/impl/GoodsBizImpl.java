package com.biz.impl;

import com.biz.IGoodsBiz;
import com.biz.Utils;
import com.dao.impl.GoodsDaoImpl;
import com.entity.Goods;
import com.entity.Page;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 18:47
 **/
public class GoodsBizImpl extends BaseBizImpl<Goods>implements IGoodsBiz {
    private GoodsDaoImpl goodsDao;

    public void setGoodsDao(GoodsDaoImpl goodsDao) {
        super.setBaseDao(goodsDao);
        this.goodsDao = goodsDao;
    }

    @Override
    public Page<Goods> findByPage(Goods goods, Goods t2, Integer page, Integer rows) {
        Page<Goods> page1 = new Page<>();
        page1.setCurrentPage(page);
        page1.setPageSize(rows);
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
        if(goods.getName()!=null && !goods.getName().trim().equals(""))
            criteria.add(Restrictions.like("name",goods.getName(), MatchMode.ANYWHERE));
        if(goods.getOrigin()!=null && !goods.getOrigin().trim().equals(""))
            criteria.add(Restrictions.like("origin",goods.getOrigin(), MatchMode.ANYWHERE));
        if(goods.getProducer()!=null && !goods.getProducer().trim().equals(""))
            criteria.add(Restrictions.like("producer",goods.getProducer(), MatchMode.ANYWHERE));
        if(goods.getGoodstype()!=null && goods.getGoodstype().getUuid()!=null){
            criteria.add(Restrictions.eq("goodstype",goods.getGoodstype()));
        }if(goods.getInprice()!=null)
            criteria.add(Restrictions.ge("inprice",goods.getInprice()));
        if(goods.getOutprice()!=null)
            criteria.add(Restrictions.ge("outprice",goods.getOutprice()));
        if(t2!=null && t2.getOutprice()!=null)
            criteria.add(Restrictions.le("outprice",t2.getOutprice()));
        if(t2!=null && t2.getInprice()!=null)
            criteria.add(Restrictions.le("inprice",t2.getInprice()));
        int totalCount = goodsDao.getCount(criteria);
        int totalPage = totalCount % rows == 0 ? totalCount / rows : (totalCount / rows) + 1;
        int begin = (page - 1) * rows;
        List<Goods> list = goodsDao.findByPage(criteria, begin, rows);
        page1.setTotalPage(totalPage);
        page1.setTotalSize(totalCount);
        page1.setList(list);
        return page1;
    }
}
