package com.biz.impl;

import com.biz.IEmpBiz;
import com.biz.Utils;
import com.dao.IEmpDao;
import com.entity.Emp;
import com.entity.Page;
import com.exception.ERPException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 18:45
 **/
public class EmpBizImpl extends BaseBizImpl<Emp> implements IEmpBiz {
    private IEmpDao empDao;
    private static final int HASH_ITERATION = 2;
    public void setEmpDao(IEmpDao empDao) {
        super.setBaseDao(empDao);
        this.empDao = empDao;
    }

    @Override
    public Page<Emp> findByPage(Emp emp,Emp emp2, Integer page, Integer rows) {

        Page<Emp> page1 = new Page<>();
        page1.setCurrentPage(page);
        page1.setPageSize(rows);
        DetachedCriteria criteria = DetachedCriteria.forClass(Emp.class);
        if(emp.getDep()!=null && emp.getDep().getUuid()!=null){
            criteria.add(Restrictions.eq("dep",emp.getDep()));
        }
        if(emp!=null && emp.getBirthday()!=null){
           criteria.add(Restrictions.ge("birthday",emp.getBirthday()));
        }
        if(emp2!=null && emp2.getBirthday()!=null){
            criteria.add(Restrictions.le("birthday",emp2.getBirthday()));
        }
        if(emp.getAddress()!=null && !emp.getAddress().trim().equals("")){
            criteria.add(Restrictions.like("address",emp.getAddress(), MatchMode.ANYWHERE));
        }
        if(emp.getName()!=null && !emp.getName().trim().equals("")){
            criteria.add(Restrictions.like("name",emp.getName(), MatchMode.ANYWHERE));
        }
        if(emp.getGender()!=null ){
            criteria.add(Restrictions.eq("gender",emp.getGender()));
        }
        if(emp.getUsername()!=null && !emp.getUsername().trim().equals("")){
            criteria.add(Restrictions.like("username",emp.getUsername(), MatchMode.ANYWHERE));
        }
        if(emp.getTele()!=null && !emp.getTele().trim().equals("")){
            criteria.add(Restrictions.like("tele",emp.getTele(), MatchMode.ANYWHERE));
        }



        int totalCount = empDao.getCount(criteria);
        int totalPage = totalCount % rows == 0 ? totalCount / rows : (totalCount / rows) + 1;
        int begin = (page - 1) * rows;
        List<Emp> list = empDao.findByPage(criteria, begin, rows);
        page1.setTotalPage(totalPage);
        page1.setTotalSize(totalCount);
        page1.setList(list);
        return page1;
    }

    @Override
    public Emp findByNameAndPwd(Emp emp) {
        if(emp.getUsername() == null || emp.getUsername().trim().equals(""))
            return null;
        if(emp.getPwd() == null || emp.getPwd().trim().equals(""))
            return null;
        emp.setPwd(getPWD(emp.getPwd(),emp.getUsername()));
        System.out.println(emp.getPwd());
        return empDao.findByNameAndPassWord(emp);
    }

    @Override
    public void updatePWD(Emp emp, String newPwd,String oldPwd) {
        //System.out.println(oldPwd);
        String pwd = emp.getPwd();
        System.out.println(pwd + " "+getPWD(oldPwd,emp.getUsername())+" "+getPWD(newPwd,emp.getUsername()));
        if(!getPWD(oldPwd,emp.getUsername()).equals(pwd)){
            throw new ERPException("旧密码不正确");
        }else {
            String pwdPass = getPWD(newPwd,emp.getUsername());
            emp.setPwd(pwdPass);
            System.out.println(emp.getPwd());
            empDao.update(emp);
        }
    }

    @Override
    public void updateResetPWD(Emp tmpEmp) {
        tmpEmp.setPwd(getPWD(tmpEmp.getPwd(),tmpEmp.getUsername()));
        empDao.update(tmpEmp);
    }


    private String getPWD(String pwd, String username) {
        Md5Hash md5Hash = new Md5Hash(pwd,username,HASH_ITERATION);
        return md5Hash.toString();
    }

    @Override
    public void add(Emp emp) {
        //String pwd = emp.getPwd();
        /**
         * 源码
         * 搅乱吗
         * 搅乱次数
         * 初始密码为用户名
         */
        String newPwd = getPWD(emp.getUsername(), emp.getUsername());
        emp.setPwd(newPwd);
        super.add(emp);
    }



}
