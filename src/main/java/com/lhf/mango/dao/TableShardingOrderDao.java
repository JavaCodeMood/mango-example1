package com.lhf.mango.dao;

/**
 * @ClassName: TableShardingOrderDao
 * @Desc:  表分片
 * @Author: liuhefei
 * @Date: 2018/12/21 11:21
 */

import com.lhf.mango.entity.Order;
import com.lhf.mango.tableShard.OrderTableShardingStrategy;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;
import org.jfaster.mango.annotation.TableShardingBy;

import java.util.List;

/**表分片策略：
 * 数据库中有t_order_0与t_order_1共2张表，我们按照用户ID（后续简称uid）纬度进行表分片：
 *
 * uid小于等于1000时，使用t_order_0表
 * uid大于1000时，时使用t_order_1表
 */
@DB(table = "t_order")
@Sharding(tableShardingStrategy = OrderTableShardingStrategy.class) //使用 @Sharding 注解中的tableShardingStrategy参数，将表分片策略与DAO接口进行绑定
public interface TableShardingOrderDao {
    //插入订单
    @SQL("insert into #table(id,uid,price,status) values(:id,:uid,:price,:status)")
    public void addOrder(@TableShardingBy("uid") Order order); // @TableShardingBy 注解用于指定给表分片策略传入的参数

    //读取订单
    @SQL("select id,uid,price,status from #table where uid =:1")
    public List<Order> getOrdersByUid(@TableShardingBy int uid);
}
