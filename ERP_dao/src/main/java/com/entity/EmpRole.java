package com.entity;

import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:49
 **/
public class EmpRole {
    private long uuid;
    private Long empuuid;
    private Long roleuuid;

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public Long getEmpuuid() {
        return empuuid;
    }

    public void setEmpuuid(Long empuuid) {
        this.empuuid = empuuid;
    }

    public Long getRoleuuid() {
        return roleuuid;
    }

    public void setRoleuuid(Long roleuuid) {
        this.roleuuid = roleuuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpRole empRole = (EmpRole) o;
        return uuid == empRole.uuid &&
                Objects.equals(empuuid, empRole.empuuid) &&
                Objects.equals(roleuuid, empRole.roleuuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, empuuid, roleuuid);
    }
}
