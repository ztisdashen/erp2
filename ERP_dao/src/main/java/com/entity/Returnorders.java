package com.entity;

import java.sql.Time;
import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:50
 **/
public class Returnorders {
    private long uuid;
    private Time createtime;
    private Time checktime;
    private Time endtime;
    private String type;
    private Long creater;
    private Long checker;
    private Long ender;
    private Long supplieruuid;
    private Long totalmoney;
    private String state;
    private Long waybillsn;
    private Long ordersuuid;

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
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

    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Long getEnder() {
        return ender;
    }

    public void setEnder(Long ender) {
        this.ender = ender;
    }

    public Long getSupplieruuid() {
        return supplieruuid;
    }

    public void setSupplieruuid(Long supplieruuid) {
        this.supplieruuid = supplieruuid;
    }

    public Long getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Long totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getWaybillsn() {
        return waybillsn;
    }

    public void setWaybillsn(Long waybillsn) {
        this.waybillsn = waybillsn;
    }

    public Long getOrdersuuid() {
        return ordersuuid;
    }

    public void setOrdersuuid(Long ordersuuid) {
        this.ordersuuid = ordersuuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Returnorders that = (Returnorders) o;
        return uuid == that.uuid &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(checktime, that.checktime) &&
                Objects.equals(endtime, that.endtime) &&
                Objects.equals(type, that.type) &&
                Objects.equals(creater, that.creater) &&
                Objects.equals(checker, that.checker) &&
                Objects.equals(ender, that.ender) &&
                Objects.equals(supplieruuid, that.supplieruuid) &&
                Objects.equals(totalmoney, that.totalmoney) &&
                Objects.equals(state, that.state) &&
                Objects.equals(waybillsn, that.waybillsn) &&
                Objects.equals(ordersuuid, that.ordersuuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, createtime, checktime, endtime, type, creater, checker, ender, supplieruuid, totalmoney, state, waybillsn, ordersuuid);
    }
}
