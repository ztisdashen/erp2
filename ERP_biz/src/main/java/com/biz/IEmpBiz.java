package com.biz;

import com.entity.Emp;

public interface IEmpBiz extends IBaseBiz<Emp> {
    Emp findByNameAndPwd(Emp emp);
}
