package web.action;

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
public class DepAction extends ActionSupport implements ModelDriven<Dep>{
    private Dep dep = new Dep();


    private IDepBiz depBiz;

    private Integer page;
    private Integer rows;
    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }


    @Override
    public Dep getModel() {

        return dep;
    }

    public void setDepBiz(IDepBiz depBiz) {
        this.depBiz = depBiz;
    }

    public String findAll() {
        //条件查询
        Page<Dep> pages = depBiz.findByPage(dep, page, rows);
        //System.out.println(pages);
        Map<String, Object> map = new HashMap<>();
        map.put("total", pages.getTotalSize());
        map.put("rows", pages.getList());
        String jsonString = JSON.toJSONString(map);

        respone(jsonString);
        return NONE;
    }

    private void respone(String jsonString) {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String save() {
        Map<String, String> map = new HashMap<>();
        try {
            depBiz.add(dep);
            map.put("msg", "添加成功");
        } catch (Exception e) {
            map.put("msg", "添加失败");
        }
        String jsonString = JSON.toJSONString(map);
        respone(jsonString);
        return NONE;
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

    private void ajaxReturn(String msg, String info) {
        Map<String, String> map = new HashMap<>();
        map.put(msg, info);
        String jsonString = JSON.toJSONString(map);
        respone(jsonString);
    }

    /**
     * 回显数据
     *
     * @return
     */
    public String edit() {
        Dep byId = depBiz.findById(dep.getUuid());
        String jsonString = JSON.toJSONString(byId);
        respone(jsonString);
        return NONE;
    }

    public String editFinal() {
        try {
            depBiz.edit(dep);
            ajaxReturn("msg","修改成功");
        } catch (Exception e) {
            ajaxReturn("msg","修改失败");
        }

        return NONE;
    }
}
