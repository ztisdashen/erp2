package com.entity;

import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:50
 **/
public class Store {
    private long uuid;
    private String name;
    private Long empuuid;

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

    public Long getEmpuuid() {
        return empuuid;
    }

    public void setEmpuuid(Long empuuid) {
        this.empuuid = empuuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return uuid == store.uuid &&
                Objects.equals(name, store.name) &&
                Objects.equals(empuuid, store.empuuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, empuuid);
    }
}
