package com.lhf.mango.Sharding;

import org.jfaster.mango.sharding.ShardingStrategy;

/**
 * @ClassName: OrderShardingStrategy
 * @Desc: 将表分片，数据库分库策略合在一起
 * 接口ShardingStrategy同时继承 DatabaseShardingStrategy, TableShardingStrategy
 * @Author: liuhefei
 * @Date: 2018/12/21 15:50
 */
public class OrderShardingStrategy implements ShardingStrategy<Integer, Integer> {

    //分库策略
    public String getDataSourceFactoryName(Integer uid) {
        return "dsf" + uid % 3;
    }

    //分表策略
    public String getTargetTable(String table, Integer uid) {
        int num = uid <= 1000 ? 0 : 1;
        return table + "_" + num;
    }
}
