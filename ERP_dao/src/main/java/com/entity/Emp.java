package com.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-07-18 17:49
 **/
public class Emp {
    private Long uuid;
    private String username;
    //不让他序列化
    @JSONField(serialize = false)
    private String pwd;
    private String name;
    private Long gender;
    private String email;
    private String tele;
    private String address;
    private Date birthday;
    private Dep dep;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Dep getDep() {
        return dep;
    }

    public void setDep(Dep dep) {
        this.dep = dep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emp)) return false;
        Emp emp = (Emp) o;
        return Objects.equals(getUuid(), emp.getUuid()) &&
                Objects.equals(getUsername(), emp.getUsername()) &&
                Objects.equals(getPwd(), emp.getPwd()) &&
                Objects.equals(getName(), emp.getName()) &&
                Objects.equals(getGender(), emp.getGender()) &&
                Objects.equals(getEmail(), emp.getEmail()) &&
                Objects.equals(getTele(), emp.getTele()) &&
                Objects.equals(getAddress(), emp.getAddress()) &&
                Objects.equals(getBirthday(), emp.getBirthday()) &&
                Objects.equals(getDep(), emp.getDep());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getUsername(), getPwd(), getName(), getGender(), getEmail(), getTele(), getAddress(), getBirthday(), getDep());
    }

    @Override
    public String toString() {
        return "Emp{" +
                "uuid=" + uuid +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", tele='" + tele + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", dep=" + dep +
                '}';
    }
}
