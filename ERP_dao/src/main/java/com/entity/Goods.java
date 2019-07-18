package com.entity;

import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:49
 **/
public class Goods {
    private long uuid;
    private String name;
    private String origin;
    private String producer;
    private String unit;
    private Long inprice;
    private Long outprice;
    private Long goodstypeuuid;

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getInprice() {
        return inprice;
    }

    public void setInprice(Long inprice) {
        this.inprice = inprice;
    }

    public Long getOutprice() {
        return outprice;
    }

    public void setOutprice(Long outprice) {
        this.outprice = outprice;
    }

    public Long getGoodstypeuuid() {
        return goodstypeuuid;
    }

    public void setGoodstypeuuid(Long goodstypeuuid) {
        this.goodstypeuuid = goodstypeuuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return uuid == goods.uuid &&
                Objects.equals(name, goods.name) &&
                Objects.equals(origin, goods.origin) &&
                Objects.equals(producer, goods.producer) &&
                Objects.equals(unit, goods.unit) &&
                Objects.equals(inprice, goods.inprice) &&
                Objects.equals(outprice, goods.outprice) &&
                Objects.equals(goodstypeuuid, goods.goodstypeuuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, origin, producer, unit, inprice, outprice, goodstypeuuid);
    }
}
