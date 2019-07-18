package com.entity;

import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:50
 **/
public class RoleMenu {
    private long uuid;
    private Long roleuuid;
    private String menuuuid;

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public Long getRoleuuid() {
        return roleuuid;
    }

    public void setRoleuuid(Long roleuuid) {
        this.roleuuid = roleuuid;
    }

    public String getMenuuuid() {
        return menuuuid;
    }

    public void setMenuuuid(String menuuuid) {
        this.menuuuid = menuuuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleMenu roleMenu = (RoleMenu) o;
        return uuid == roleMenu.uuid &&
                Objects.equals(roleuuid, roleMenu.roleuuid) &&
                Objects.equals(menuuuid, roleMenu.menuuuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, roleuuid, menuuuid);
    }
}
