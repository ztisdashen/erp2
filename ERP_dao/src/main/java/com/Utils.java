package com;

import com.entity.Dep;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 09:11
 **/
public class Utils {
    /**
     * 仅适用于String属性的模糊离线查询
      * @param t
     * @param tClass
     * @param <T>
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static <T> DetachedCriteria getDetachedCriteria(T t,Class<? extends T> tClass) throws InvocationTargetException, IllegalAccessException {
        DetachedCriteria criteria = DetachedCriteria.forClass(tClass);
        if (t != null) {
            Field[] fields = tClass.getDeclaredFields();
            Method[] methods = tClass.getMethods();
            for (Field field : fields) {
                if(field.getType().toString().equals("class java.lang.String")){
                    for (Method method : methods) {
                        if(method.getName().equalsIgnoreCase("get"+field.getName())){
                            String result = (String) method.invoke(t);
                            if(result!=null && !result.trim().equals("") )
                                criteria.add(Restrictions.like(field.getName(), result, MatchMode.ANYWHERE));
                        }
                    }
                }
            }
        }
        return criteria;
    }

}
