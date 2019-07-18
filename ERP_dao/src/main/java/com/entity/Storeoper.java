package com.entity;

import java.sql.Time;
import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:50
 **/
public class Storeoper {
    private long uuid;
    private Long empuuid;
    private Time opertime;
    private Long storeuuid;
    private Long goodsuuid;
    private Long num;
    private String type;

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

    public Time getOpertime() {
        return opertime;
    }

    public void setOpertime(Time opertime) {
        this.opertime = opertime;
    }

    public Long getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(Long storeuuid) {
        this.storeuuid = storeuuid;
    }

    public Long getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(Long goodsuuid) {
        this.goodsuuid = goodsuuid;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storeoper storeoper = (Storeoper) o;
        return uuid == storeoper.uuid &&
                Objects.equals(empuuid, storeoper.empuuid) &&
                Objects.equals(opertime, storeoper.opertime) &&
                Objects.equals(storeuuid, storeoper.storeuuid) &&
                Objects.equals(goodsuuid, storeoper.goodsuuid) &&
                Objects.equals(num, storeoper.num) &&
                Objects.equals(type, storeoper.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, empuuid, opertime, storeuuid, goodsuuid, num, type);
    }
}
