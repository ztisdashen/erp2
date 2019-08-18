package com.web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IDepBiz;
import com.entity.Dep;
import com.entity.Page;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.boot.spi.InFlightMetadataCollector;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-17 14:11
 **/
public class DepAction extends BaseAction<Dep> implements ModelDriven<Dep>{
    private Dep dep = new Dep();


    private IDepBiz depBiz;

    @Override
    public Dep getModel() {
        super.setT(dep);
        return dep;
    }

    public void setDepBiz(IDepBiz depBiz) {
        super.setBaseBiz(depBiz);
        this.depBiz = depBiz;
    }




    public String delete() {
        try {
            Dep t1 = depBiz.findById(dep.getUuid());
            depBiz.delete(t1);
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
        Dep byId = depBiz.findById(dep.getUuid());
        String jsonString = JSON.toJSONString(byId);
        response(jsonString);
        return NONE;
    }

}
