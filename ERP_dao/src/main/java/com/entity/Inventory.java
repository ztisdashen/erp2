package com.entity;

import java.sql.Time;
import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:49
 **/
public class Inventory {
    private long uuid;
    private Long goodsuuid;
    private Long storeuuid;
    private Long num;
    private String type;
    private Time createtime;
    private Time checktime;
    private Long creater;
    private Long checker;
    private String state;
    private String remark;

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public Long getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(Long goodsuuid) {
        this.goodsuuid = goodsuuid;
    }

    public Long getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(Long storeuuid) {
        this.storeuuid = storeuuid;
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

    public Time getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Time createtime) {
        this.createtime = createtime;
    }

    public Time getChecktime() {
        return checktime;
    }

    public void setChecktime(Time checktime) {
        this.checktime = checktime;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Long getChecker() {
        return checker;
    }

    public void setChecker(Long checker) {
        this.checker = checker;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return uuid == inventory.uuid &&
                Objects.equals(goodsuuid, inventory.goodsuuid) &&
                Objects.equals(storeuuid, inventory.storeuuid) &&
                Objects.equals(num, inventory.num) &&
                Objects.equals(type, inventory.type) &&
                Objects.equals(createtime, inventory.createtime) &&
                Objects.equals(checktime, inventory.checktime) &&
                Objects.equals(creater, inventory.creater) &&
                Objects.equals(checker, inventory.checker) &&
                Objects.equals(state, inventory.state) &&
                Objects.equals(remark, inventory.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, goodsuuid, storeuuid, num, type, createtime, checktime, creater, checker, state, remark);
    }
}
