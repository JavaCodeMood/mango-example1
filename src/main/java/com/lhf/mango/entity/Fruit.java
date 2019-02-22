package com.lhf.mango.entity;

import org.jfaster.mango.annotation.ID;

/**
 * @ClassName: Fruit
 * @Desc:  水果实体
 * @Author: liuhefei
 * @Date: 2018/12/20 15:31
 */
public class Fruit {
    @ID
    private Integer id;

    private String name;

    private int num;

    private double price;

    private  String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", address='" + address + '\'' +
                '}';
    }
}
