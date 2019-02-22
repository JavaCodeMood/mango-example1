package com.lhf.mango.dao;

import com.lhf.mango.entity.User;
import org.jfaster.mango.annotation.*;
import org.jfaster.mango.operator.cache.Hour;

import java.util.List;

/**
 * @ClassName: UserCacheDao
 * @Desc:  Mango缓存使用
 * @Cache表示需要使用缓存，参数prefix表示key前缀，比如说传入uid=1，那么缓存中的key就等于user_1，参数expire表示缓存过期时间，Hour.class表示小时，配合后面的参数num＝2表示缓存过期的时间为2小时。
 * @CacheBy用于修饰key后缀参数，在delete，update，getUser方法中@CacheBy都是修饰的uid，所以当传入uid=1时，缓存中的key就等于user_1。
 * @CacheIgnored表示该方法不操作缓存。需要注意的是，如果使用了@Cache注解，@CacheBy和@CacheIgnored二者必须有一个存在。
 *
 * @Author: liuhefei
 * @Date: 2018/12/21 18:15
 */
@DB
@Cache(prefix = "user", expire = Hour.class, num = 2)
public interface UserCacheDao {

    @CacheIgnored   //不使用缓存
    @SQL("insert into user(name, age, gender, money, update_time) values(:name, :age, :gender, :money, :updateTime)")
    public int insert(User user);

    @SQL("insert into user(name, age, gender, money, update_time) values(:1.name, :1.age, :1.gender, :1.money, :1.updateTime)")
    public int insertUser(@CacheBy("name") User user);  //使用User对象的name属性作为key后缀

    @SQL("delete from user where id =:1")
    public int delete(@CacheBy int id );

    @SQL("update user set name = :2 where id =:1")
    public int update(@CacheBy int id, String name);

    @SQL("select * from user where id=:1")
    public User getUser(@CacheBy int id);

    @SQL("select * from user where id in (:1)")
    public List<User> getUserList(@CacheBy List<Integer> ids);

    @SQL("select id, name from user where id=:1 and name=:2")
    public User getByUidAndName(@CacheBy int id, @CacheBy String name); //同时使用id和name两个字段来做缓存

}
