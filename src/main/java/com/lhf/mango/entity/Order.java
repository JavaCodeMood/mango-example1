package com.lhf.mango.entity;

/**
 * @ClassName: Order
 * @Desc:
 * @Author: liuhefei
 * @Date: 2018/12/21 11:17
 */
public class Order {

    private String id;

    private int uid;

    private int price;

    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", uid=" + uid +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
