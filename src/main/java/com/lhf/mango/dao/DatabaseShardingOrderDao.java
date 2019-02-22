package com.lhf.mango.dao;

import com.lhf.mango.databaseShard.OrderDatabaseShardingStrategy;
import com.lhf.mango.entity.Order;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.DatabaseShardingBy;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;

import java.util.List;

/**
 * @ClassName: DatabaseShardingOrderDao
 * @Desc:  分库
 * @Author: liuhefei
 * @Date: 2018/12/21 14:14
 */
@DB(table = "t_order")
@Sharding(databaseShardingStrategy = OrderDatabaseShardingStrategy.class)  // @Sharding 注解中的databaseShardingStrategy参数，将数据库分片策略与DAO接口进行绑定
public interface DatabaseShardingOrderDao {

    @SQL("insert into #table(id,uid,price,status) values(:id,:uid,:price,:status)")
    public void addOrder(@DatabaseShardingBy("uid") Order order);  //引入了 @DatabaseShardingBy 注解用于指定给数据库分片策略传入的参数

    @SQL("select id,uid,price,status from #table where uid =:1")
    public List<Order> getOrdersByUid(@DatabaseShardingBy int uid);
}
