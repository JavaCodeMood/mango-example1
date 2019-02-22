package com.lhf.mango.entity;

import org.jfaster.mango.annotation.ID;

import java.util.Date;

/**
 * @ClassName: Article
 * @Desc: 文章实体
 * @Author: liuhefei
 * @Date: 2018/12/20 19:26
 */
public class Article {
    @ID
    private Integer id;

    private String title;

    private String content;

    private String author;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
