package com.lhf.mango.entity;

import org.jfaster.mango.annotation.ID;

/**
 * @ClassName: Comment
 * @Desc:
 * @Author: liuhefei
 * @Date: 2018/12/21 9:54
 */
public class Comment {
    @ID
    private Integer id;

    private Integer uid;

    private  String title;

    private  String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
