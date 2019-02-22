package com.lhf.mango.dao;

import com.lhf.mango.entity.Article;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

@DB
public interface ArticleDao {
    @ReturnGeneratedId
    @SQL("insert into article(id, title, content, author, update_time) values(:id, :title, :content, :author, :updateTime)")
    public int addArticle(Article article);

    @SQL("select * from article where id = :1")
    public Article getArticle(int id);

    @SQL("select count(*) from article")
    public int count();
}
