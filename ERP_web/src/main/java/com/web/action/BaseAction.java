package com.web.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.biz.IBaseBiz;
import com.entity.Page;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 21:02
 **/
public class BaseAction<T> extends ActionSupport {
    private T t;
    private T t2;
    private IBaseBiz<T> baseBiz;
    private Integer page;
    private Integer rows;
    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
    public void setT(T t) {
        this.t = t;
    }

    public void setBaseBiz(IBaseBiz<T> baseBiz) {
        this.baseBiz = baseBiz;
    }

    public String listAll(){
        List<T> list = baseBiz.findAll(t);
        String toJSONString = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
        response(toJSONString);
        return NONE;
    }

    public String findAll() {
        //条件查询
        Page<T> pages = baseBiz.findByPage(t,t2, page, rows);
        Map<String, Object> map = new HashMap<>();
        map.put("total", pages.getTotalSize());
        map.put("rows", pages.getList());
        //禁用引用,如果发现有相同的对象，就会变成引用，而不直接的
        String jsonString = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);

        response(jsonString);
        return NONE;
    }

    public void response(String jsonString) {
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
        response(jsonString);
        return NONE;
    }
    public void ajaxReturn(Object msg, Object info) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", msg);
        map.put("msg",info);
        String jsonString = JSON.toJSONString(map);
        response(jsonString);
    }
    public void ajaxReturn(String msg, String info) {
        Map<String, String> map = new HashMap<>();
        map.put(msg, info);
        String jsonString = JSON.toJSONString(map);
        response(jsonString);
    }

    public String editFinal() {
        try {
            baseBiz.edit(t);
            ajaxReturn("msg","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            ajaxReturn("msg","修改失败");
        }

        return NONE;
    }

    public void setT2(T t2) {
        this.t2 = t2;
    }
}
