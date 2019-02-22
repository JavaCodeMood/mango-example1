package com.lhf.mango;

import com.lhf.mango.dao.BlogDao;
import com.lhf.mango.dao.CommentDao;
import com.lhf.mango.entity.Blog;
import com.lhf.mango.entity.Comment;
import org.jfaster.mango.datasource.DataSourceFactory;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.datasource.MasterSlaveDataSourceFactory;
import org.jfaster.mango.datasource.SimpleDataSourceFactory;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.util.logging.MangoLogger;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: MangoDemo2
 * @Desc: 混合数据库（集群）实例：单一数据库 + 主从数据库
 * @Author: liuhefei
 * @Date: 2018/12/20 19:01
 */
public class MangoDemo2 {
    String driverClassName = "com.mysql.jdbc.Driver";
    String username = "root";
    String password = "root";
    //主从数据源
    String url = "jdbc:mysql://localhost:3306/mango_example?useSSL=false";
    String url1 = "jdbc:mysql://localhost:3306/mango_example0?useSSL=false";
    String url2 = "jdbc:mysql://localhost:3306/mango_example1?useSSL=false";

    String name1 = "dsf1";
    DataSource master = new DriverManagerDataSource(driverClassName, url, username, password);
    DataSource slave1 = new DriverManagerDataSource(driverClassName, url1, username, password);
    DataSource slave2 = new DriverManagerDataSource(driverClassName, url2, username, password);
    List<DataSource> slaves = Arrays.asList(slave1, slave2);
    DataSourceFactory dsf1 = new MasterSlaveDataSourceFactory(name1, master, slaves);

    //单一数据源
    String name2 = "dsf2";
    String url3 = "jdbc:mysql://localhost:3306/mango_example2";
    DataSource dataSource = new DriverManagerDataSource(driverClassName,url3, username,password);
    DataSourceFactory dsf2 = new SimpleDataSourceFactory(name2, dataSource);
    Mango mango = Mango.newInstance(Arrays.asList(dsf1, dsf2));
    BlogDao blogDao = mango.create(BlogDao.class);
    CommentDao commentDao = mango.create(CommentDao.class);

    public static void main(String[] args){
        MangoLogger.useLog4JLogger(); // 使用log4j输出日志，log4j.xml文件在resources目录下

        MangoDemo2 mangoDemo2 = new MangoDemo2();
        Blog blog = new Blog();
        Comment comment = new Comment();

        blog.setUid(2);
        blog.setTitle("伤心往事");
        blog.setContent("没有了你，虽有万杯觥筹，只不过是提醒寂寞罢了");
        mangoDemo2.addBlog(blog);
        mangoDemo2.getBlog(1);

        comment.setUid(2);
        comment.setTitle("斜风细雨");
        comment.setContent("风似刀，雨如毛");
        mangoDemo2.addComment(comment);
        mangoDemo2.getComment(1);

    }

    public int addBlog(Blog blog){
        int num = blogDao.addBlog(blog);
        if(num > 0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
        return num;
    }

    public Blog getBlog(int id){
        Blog blog = blogDao.getBlog(id);
        System.out.println("blog = " + blog);
        return blog;
    }

    public int addComment(Comment comment){
       int num = commentDao.addComment(comment);
        if(num > 0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
        return num;
    }

    public Comment getComment(int id){
        Comment comment = commentDao.getComment(id);
        System.out.println("comment = " + comment);
        return comment;
    }

}
