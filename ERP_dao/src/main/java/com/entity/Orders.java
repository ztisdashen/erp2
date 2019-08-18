package com.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:50
 **/
public class Orders {
    public static final String STATE_CREATE = "0";
    public static final String STATE_CHECK = "1";
    public static final String STATE_START = "2";
    public static final String STATE_END = "3";
    public static final String TYPE_IN = "1";
    public static final String TYPE_OUT = "2";
    private Long uuid;
    private Date createtime;
    private Date checktime;
    private Date starttime;
    private Date endtime;
    private String type;
    private Long creater;
    private Long checker;
    private Long starter;
    private Long ender;
    private Long supplieruuid;
    private Double totalmoney;
    private String state;
    private Long waybillsn;
    private List<Orderdetail> orderdetails;

    public List<Orderdetail> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<Orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
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

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
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
