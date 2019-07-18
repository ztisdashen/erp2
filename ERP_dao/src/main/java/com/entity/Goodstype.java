package com.entity;

import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:49
 **/
public class Goodstype {
    private long uuid;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goodstype goodstype = (Goodstype) o;
        return uuid == goodstype.uuid &&
                Objects.equals(name, goodstype.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name);
    }
}
