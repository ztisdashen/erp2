package com.biz;

import com.entity.Emp;

public interface IEmpBiz extends IBaseBiz<Emp> {
    Emp findByNameAndPwd(Emp emp);

    void updatePWD(Emp emp,String newPwd,String oldPwd);

    void updateResetPWD(Emp tmpEmp);
}
