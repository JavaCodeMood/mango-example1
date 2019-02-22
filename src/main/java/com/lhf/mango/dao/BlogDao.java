package com.lhf.mango.dao;

import com.lhf.mango.entity.Blog;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

@DB(name = "dsf1")  //name用于指定所使用数据源工厂的名字
public interface BlogDao {
    @ReturnGeneratedId
    @SQL("insert into blog(uid,title,content) values(:uid,:title,:content)")
    public int addBlog(Blog blog);

    @SQL("select id,uid, title, content from blog where id =:1")
    public Blog getBlog(int id);

}
