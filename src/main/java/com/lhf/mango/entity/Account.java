package com.lhf.mango.entity;

import org.jfaster.mango.annotation.ID;

/**
 * @ClassName: Account
 * @Desc:
 * @Author: liuhefei
 * @Date: 2018/12/24 9:23
 */
public class Account {
    @ID
    private int uid;

    private String name;

    private int money;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
