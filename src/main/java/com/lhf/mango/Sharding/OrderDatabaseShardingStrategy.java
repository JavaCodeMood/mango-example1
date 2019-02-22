package com.lhf.mango.Sharding;

import org.jfaster.mango.sharding.DatabaseShardingStrategy;

/**
 * @ClassName: OrderDatabaseShardingStrategy
 * @Desc: 数据库分库策略
 * 要实现数据库分库，需要实现实现了 DatabaseShardingStrategy 接口中的 getDataSourceFactoryName 方法。
 *
 * getDataSourceFactoryName方法是数据库分片策略的核心，返回最终请求的数据源工厂名称。
 * 而getDataSourceFactoryName方法的输入参数是一个自定义传入的参数，这里由于我们要使用uid计算如何分库，所以参数为uid
 * @Author: liuhefei
 * @Date: 2018/12/21 15:30
 */
public class OrderDatabaseShardingStrategy implements DatabaseShardingStrategy<Integer> {

    /**
     * uid模3为0的请求落在数据库db0
     * uid模3为1的请求落在数据库db1
     * uid模3为2的请求落在数据库db2
     * @param uid
     * @return
     */
    public String getDataSourceFactoryName(Integer uid) {
        return "dsf" + uid % 3;
    }
}
