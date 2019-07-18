package com.entity;

import java.sql.Time;
import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:49
 **/
public class Orderdetail {
    private long uuid;
    private Long goodsuuid;
    private String goodsname;
    private Long price;
    private Long num;
    private Long money;
    private Time endtime;
    private Long ender;
    private Long storeuuid;
    private String state;
    private Long ordersuuid;

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

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    public Long getEnder() {
        return ender;
    }

    public void setEnder(Long ender) {
        this.ender = ender;
    }

    public Long getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(Long storeuuid) {
        this.storeuuid = storeuuid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        Orderdetail that = (Orderdetail) o;
        return uuid == that.uuid &&
                Objects.equals(goodsuuid, that.goodsuuid) &&
                Objects.equals(goodsname, that.goodsname) &&
                Objects.equals(price, that.price) &&
                Objects.equals(num, that.num) &&
                Objects.equals(money, that.money) &&
                Objects.equals(endtime, that.endtime) &&
                Objects.equals(ender, that.ender) &&
                Objects.equals(storeuuid, that.storeuuid) &&
                Objects.equals(state, that.state) &&
                Objects.equals(ordersuuid, that.ordersuuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, goodsuuid, goodsname, price, num, money, endtime, ender, storeuuid, state, ordersuuid);
    }
}
