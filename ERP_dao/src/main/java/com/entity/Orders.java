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
    private String createrName;
    private Long checker;
    private String checkerName;
    private Long starter;
    private String starterName;
    private Long ender;
    private String enderName;
    private Long supplieruuid;
    private String supplierName;
    private Double totalmoney;
    private String state;
    private Long waybillsn;
    private List<Orderdetail> orderdetails;

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public String getStarterName() {
        return starterName;
    }

    public void setStarterName(String starterName) {
        this.starterName = starterName;
    }

    public String getEnderName() {
        return enderName;
    }

    public void setEnderName(String enderName) {
        this.enderName = enderName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

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

    @Override
    public String toString() {
        return "Orders{" +
                "uuid=" + uuid +
                ", createtime=" + createtime +
                ", checktime=" + checktime +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", type='" + type + '\'' +
                ", creater=" + creater +
                ", createrName='" + createrName + '\'' +
                ", checker=" + checker +
                ", checkerName='" + checkerName + '\'' +
                ", starter=" + starter +
                ", starterName='" + starterName + '\'' +
                ", ender=" + ender +
                ", enderName='" + enderName + '\'' +
                ", supplieruuid=" + supplieruuid +
                ", supplierName='" + supplierName + '\'' +
                ", totalmoney=" + totalmoney +
                ", state='" + state + '\'' +
                ", waybillsn=" + waybillsn +
                ", orderdetails=" + orderdetails +
                '}';
    }
}
