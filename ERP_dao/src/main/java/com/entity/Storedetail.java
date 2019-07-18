package com.entity;

import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:50
 **/
public class Storedetail {
    private long uuid;
    private Long storeuuid;
    private Long goodsuuid;
    private Long num;

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storedetail that = (Storedetail) o;
        return uuid == that.uuid &&
                Objects.equals(storeuuid, that.storeuuid) &&
                Objects.equals(goodsuuid, that.goodsuuid) &&
                Objects.equals(num, that.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, storeuuid, goodsuuid, num);
    }
}
