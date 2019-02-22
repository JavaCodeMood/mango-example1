package com.lhf.mango;

import com.lhf.mango.dao.ArticleDao;
import com.lhf.mango.dao.FruitDao;
import com.lhf.mango.entity.Article;
import com.lhf.mango.entity.Fruit;
import org.jfaster.mango.datasource.DataSourceFactory;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.datasource.MasterSlaveDataSourceFactory;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.util.logging.MangoLogger;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName: MangoDemo1
 * @Desc:  主从数据库实例
 * @Author: liuhefei
 * @Date: 2018/12/20 19:00
 */
public class MangoDemo1 {

    String driverClassName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/mango_example?useSSL=false";
    String url1 = "jdbc:mysql://localhost:3306/mango_example0?useSSL=false";
    String url2 = "jdbc:mysql://localhost:3306/mango_example1?useSSL=false";
    String username = "root";
    String password = "root";

    //初始化master数据库
    DataSource master = new DriverManagerDataSource(driverClassName, url, username, password);
    //初始化slave数据库
    DataSource slave1 = new DriverManagerDataSource(driverClassName, url1, username, password);
    DataSource slave2 = new DriverManagerDataSource(driverClassName, url2, username, password);
    //初始化数据源工厂
    DataSourceFactory dsf = new MasterSlaveDataSourceFactory(master, Arrays.asList(slave1, slave2));
    Mango mango = Mango.newInstance(dsf) ;
    ArticleDao articleDao = mango.create(ArticleDao.class);

    public static void main(String[] args){
        MangoLogger.useSlf4JLogger(); // 使用slf4j输出日志，logback.xml文件在resources目录下

        MangoDemo1 mangoDemo1 = new MangoDemo1();
        mangoDemo1.add("你好", "应用服务的数据库写请求使用主库，数据库读请求使用从库时，我们使用主从数据源工厂MasterSlaveDataSourceFactory管理数据源", "刘豆豆");
        mangoDemo1.getArticle(1);
    }

    public void add(String title, String  content, String author){
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setAuthor(author);
        Date date = new Date();
        article.setUpdateTime(date);
        articleDao.addArticle(article);
    }

    public void getArticle(Integer  id){
        Article article  = articleDao.getArticle(id);
        System.out.println("article = " + article);
    }


}
