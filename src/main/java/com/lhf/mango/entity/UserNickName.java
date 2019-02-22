package com.lhf.mango.entity;

import org.jfaster.mango.annotation.ID;

/**
 * @ClassName: UserNickName
 * @Desc:
 * @Author: liuhefei
 * @Date: 2018/12/28 9:17
 */
public class UserNickName {
    @ID
    private int id;

    private String nickname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "UserNickName{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
