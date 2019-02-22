package com.lhf.mango.dao;

import com.lhf.mango.entity.Comment;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

@DB(name = "dsf2")  //name用于指定所使用数据源工厂的名字
public interface CommentDao {
    @ReturnGeneratedId
    @SQL("insert into comment(uid,title,content) values (:uid, :title, :content)")
    public int addComment(Comment comment);

    @SQL("select id, uid, title, content from comment where id = :1")
    public Comment getComment(int id);
}
