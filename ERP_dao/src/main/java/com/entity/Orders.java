package com.entity;

import java.sql.Time;
import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:50
 **/
public class Orders {
    private long uuid;
    private Time createtime;
    private Time checktime;
    private Time starttime;
    private Time endtime;
    private String type;
    private Long creater;
    private Long checker;
    private Long starter;
    private Long ender;
    private Long supplieruuid;
    private Long totalmoney;
    private String state;
    private Long waybillsn;

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

    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
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

    public Long getStarter() {
        return starter;
    }

    public void setStarter(Long starter) {
        this.starter = starter;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return uuid == orders.uuid &&
                Objects.equals(createtime, orders.createtime) &&
                Objects.equals(checktime, orders.checktime) &&
                Objects.equals(starttime, orders.starttime) &&
                Objects.equals(endtime, orders.endtime) &&
                Objects.equals(type, orders.type) &&
                Objects.equals(creater, orders.creater) &&
                Objects.equals(checker, orders.checker) &&
                Objects.equals(starter, orders.starter) &&
                Objects.equals(ender, orders.ender) &&
                Objects.equals(supplieruuid, orders.supplieruuid) &&
                Objects.equals(totalmoney, orders.totalmoney) &&
                Objects.equals(state, orders.state) &&
                Objects.equals(waybillsn, orders.waybillsn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, createtime, checktime, starttime, endtime, type, creater, checker, starter, ender, supplieruuid, totalmoney, state, waybillsn);
    }
}
