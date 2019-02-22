package com.lhf.mango.databaseShard;

import org.jfaster.mango.sharding.DatabaseShardingStrategy;

/**
 * @ClassName: OrderDatabaseShardingStrategy
 * @Desc:  数据库分片策略
 * 数据库要要实现分片，需要实现DatabaseShardingStrategy 接口中的 getDataSourceFactoryName 方法。
 * getDataSourceFactoryName方法是数据库分片策略的核心，返回最终请求的数据源工厂名称。
 * 而getDataSourceFactoryName方法的输入参数是一个自定义传入的参数，这里由于我们要使用uid计算如何分库，所以参数为uid
 *
 * 在 初始化数据库源工厂 中我们定义了dsf0，dsf1，dsf2共3个数据源工厂，分别对应db0，db1，db2这3个数据库。
 * 所以当我们想访问db0中的t_order表时，我们只需要让getDataSourceFactoryName方法返回dsf0；
 * 当我们想访问db1中的t_order表时，我们只需要让getDataSourceFactoryName方法返回dsf1，并以此类推。
 * @Author: liuhefei
 * @Date: 2018/12/21 14:14
 */
public class OrderDatabaseShardingStrategy implements DatabaseShardingStrategy<Integer> {

    public String getDataSourceFactoryName(Integer uid) {

        return "dsf" + uid % 3;
    }
}
