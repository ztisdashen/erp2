package com.entity;

import java.util.List;
import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:49
 **/
public class Menu {
    private String menuid;
    private String menuname;
    private String icon;
    private String url;
    private List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu)) return false;
        Menu menu = (Menu) o;
        return Objects.equals(getMenuid(), menu.getMenuid()) &&
                Objects.equals(getMenuname(), menu.getMenuname()) &&
                Objects.equals(getIcon(), menu.getIcon()) &&
                Objects.equals(getUrl(), menu.getUrl()) &&
                Objects.equals(getMenus(), menu.getMenus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMenuid(), getMenuname(), getIcon(), getUrl(), getMenus());
    }
}
