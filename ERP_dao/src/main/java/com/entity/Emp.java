package com.entity;

import java.sql.Time;
import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:49
 **/
public class Emp {
    private long uuid;
    private String username;
    private String pwd;
    private String name;
    private Long gender;
    private String email;
    private String tele;
    private String address;
    private Time birthday;
    private Long depuuid;

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Time getBirthday() {
        return birthday;
    }

    public void setBirthday(Time birthday) {
        this.birthday = birthday;
    }

    public Long getDepuuid() {
        return depuuid;
    }

    public void setDepuuid(Long depuuid) {
        this.depuuid = depuuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return uuid == emp.uuid &&
                Objects.equals(username, emp.username) &&
                Objects.equals(pwd, emp.pwd) &&
                Objects.equals(name, emp.name) &&
                Objects.equals(gender, emp.gender) &&
                Objects.equals(email, emp.email) &&
                Objects.equals(tele, emp.tele) &&
                Objects.equals(address, emp.address) &&
                Objects.equals(birthday, emp.birthday) &&
                Objects.equals(depuuid, emp.depuuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, username, pwd, name, gender, email, tele, address, birthday, depuuid);
    }
}
