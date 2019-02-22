package com.lhf.mango.dao;

import com.lhf.mango.Sharding.OrderDatabaseShardingStrategy;
import com.lhf.mango.Sharding.OrderTableShardingStrategy;
import com.lhf.mango.entity.Order;
import org.jfaster.mango.annotation.*;

import java.util.List;

/**
 * 分表 + 分库
 */
@DB(table = "t_order")
//绑定分表分库策略
@Sharding(
        databaseShardingStrategy = OrderDatabaseShardingStrategy.class,
        tableShardingStrategy = OrderTableShardingStrategy.class
)
public interface ShardingOrderDao {

    /**
     * @DatabaseShardingBy  用于指定给数据库分片策略传入的参数
     * @TableShardingBy  用于指定给表分片策略传入的参数
     */
    @SQL("insert into #table(id, uid, price, status) values(:id,:uid,:price,:status)")
    public void addOrder(@DatabaseShardingBy("uid") @TableShardingBy("uid")Order order);

    @SQL("select id, uid, price, status from #table where uid = :1")
    public List<Order> getOrderByUid(@DatabaseShardingBy @TableShardingBy int uid);
}
