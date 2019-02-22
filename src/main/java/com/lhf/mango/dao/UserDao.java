package com.lhf.mango.dao;

import com.lhf.mango.entity.User;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.Rename;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

import java.util.Date;
import java.util.List;

@DB
public interface UserDao {

    //insert操作
    //序号绑定参数
    @SQL("insert into user(name, age, gender, money, update_time) values(:1, :2, :3, :4, :5)")
    public void insertUser(String name, int age, boolean gender, long money, Date updateTime);

    //属性绑定
    //混合绑定
    //@Rename 定义参数别名
    @SQL("insert into user(name, age, gender, money, update_time) values(:name, :age, :gender, :money, :updateTime)")
    public void addUserByRename(@Rename("name")String name, @Rename("age")int age, @Rename("gender")boolean gender, @Rename("money")long money, @Rename("updateTime")Date updateTime);

    //属性参数绑定
    @ReturnGeneratedId //定义方法的返回值类型
    @SQL("insert into user(name, age, gender, money, update_time) " +
            "values(:1.name, :1.age, :1.gender, :1.money, :1.updateTime)")
    public int insertUser(User user);

    //属性自动匹配
    @SQL("insert into user(id, name, age) values(:id, :name, :age)")
    public void addUserByProperty(User user);

    //delete操作
    @SQL("delete from user where id =:1")
    public int deleteUser(int id);

    //属性参数绑定
    //update操作
    @SQL("update user set name=:1.name, age=:1.age, gender=:1.gender, money=:1.money, update_time=:1.updateTime where id=:1.id")
    public int updateUser(User user);

    //select操作--查询单个属性
    @SQL("select name from user where id = :1")
    public String getName(int id);

    //select操作--查询自定义对象
    @SQL("select id, name, age, gender, money, update_time from user where id = :1")
    public User getUser(int id);

    // select操作--查询多行数据
    @SQL("select id, name, age, gender, money, update_time from user where age =:1 order by id")
    public List<User> getUsersByAge(int age);

    //列表参数绑定
    //select操作--使用in语句进行查询
    //需要注意的是 in (:1) 中的参数必须是List或Set或Array，同时返回参数也必须是List或Set或Array。
    @SQL("select id, name, age, gender, money, update_time from user where id in (:1)")
    public List<User> getUsersInList(List<Integer> ids);

    //批量插入
    @SQL("insert into user(name, age, gender, money, update_time) values(:1.name, :1.age, :1.gender, :1.money, :1.updateTime)")
    public int[] batchInsertUserList(List<User> userList);

    @SQL("select count(*) from user")
    public int countUser();

}
