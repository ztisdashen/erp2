package com.entity;

import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-17 15:12
 **/
public class Dep {
    private long uuid;
    private String name;
    private String tele;

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

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dep dep = (Dep) o;
        return uuid == dep.uuid &&
                Objects.equals(name, dep.name) &&
                Objects.equals(tele, dep.tele);
    }

    @Override
    public String toString() {
        return "Dep{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", tele='" + tele + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, tele);
    }
}
