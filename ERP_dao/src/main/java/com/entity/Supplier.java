package com.entity;

import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:50
 **/
public class Supplier {
    private Long uuid;
    private String name;
    private String address;
    private String contact;
    private String tele;
    private String email;
    private String type;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return uuid == supplier.uuid &&
                Objects.equals(name, supplier.name) &&
                Objects.equals(address, supplier.address) &&
                Objects.equals(contact, supplier.contact) &&
                Objects.equals(tele, supplier.tele) &&
                Objects.equals(email, supplier.email) &&
                Objects.equals(type, supplier.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, address, contact, tele, email, type);
    }
}
