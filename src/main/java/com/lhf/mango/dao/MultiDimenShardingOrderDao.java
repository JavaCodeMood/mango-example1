package com.lhf.mango.dao;

import com.lhf.mango.MultiDimenShard.OrderIdShardingStrategy;
import com.lhf.mango.MultiDimenShard.OrderUidShardingStrategy;
import com.lhf.mango.entity.Order;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;
import org.jfaster.mango.annotation.ShardingBy;

import java.util.List;

/**
 * @ClassName: MultiDimenShardingOrderDao
 * @Desc: 多维度分片:同时使用多个参数作为分片策略的计算参数
 *
 * @Author: liuhefei
 * @Date: 2018/12/21 16:03
 */
@DB(table = "t_order")
public interface MultiDimenShardingOrderDao {
    @SQL("insert into #table(id, uid, price, status) values(:id,:uid,:price,:status)")
    @Sharding(shardingStrategy = OrderUidShardingStrategy.class)   //绑定分片策略
    public void addOrder(@ShardingBy("uid") Order order);

    @SQL("select id, uid, price, status from #table where uid = :1")
    @Sharding(shardingStrategy = OrderUidShardingStrategy.class)
    public List<Order> getOrdersByUid(@ShardingBy int uid);

    @SQL("select id, uid, price, status from #table where id = :1")
    @Sharding(shardingStrategy = OrderIdShardingStrategy.class )
    public Order getOrderById(@ShardingBy String id);
}
