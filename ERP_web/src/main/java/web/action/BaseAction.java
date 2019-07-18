package web.action;

import com.alibaba.fastjson.JSON;
import com.biz.IBaseBiz;
import com.entity.Dep;
import com.entity.Page;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.objenesis.instantiator.perc.PercInstantiator;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 15:58
 **/
public class BaseAction<T> extends ActionSupport{

    private T t;
    private IBaseBiz<T> baseBiz;

    private Integer page;
    private Integer rows;
    private Long uuid;

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
    
    public void setBaseBiz(IBaseBiz<T> baseBiz) {
        this.baseBiz = baseBiz;
    }


    public String findAll() {
        //条件查询
        Page<T> pages = baseBiz.findByPage(t, page, rows);
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
            baseBiz.add(t);
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
            T t1 = baseBiz.findById(uuid);
            baseBiz.delete(t1);
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
        T byId = baseBiz.findById(uuid);
        String jsonString = JSON.toJSONString(byId);
        respone(jsonString);
        return NONE;
    }

    public String editFinal() {
        try {
            baseBiz.edit(t);
            ajaxReturn("msg","修改成功");
        } catch (Exception e) {
            ajaxReturn("msg","修改失败");
        }

        return NONE;
    }
}
