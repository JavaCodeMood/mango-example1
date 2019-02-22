package com.lhf.mango.entity;

import org.jfaster.mango.annotation.ID;

import java.util.Date;

/**
 * @ClassName: User
 * @Desc:
 * @Author: liuhefei
 * @Date: 2018/12/20 16:47
 */
public class User {
    @ID
    private int id;
    private String name;
    private int age;
    private boolean gender;
    private Long money;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", money=" + money +
                ", updateTime=" + updateTime +
                '}';
    }
}
