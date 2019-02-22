package com.lhf.mango.MultiDimenShard;

import org.jfaster.mango.sharding.ShardingStrategy;

/**
 * @ClassName: OrderIdShardingStrategy
 * @Desc: 分表 + 分库
 * @Author: liuhefei
 * @Date: 2018/12/21 16:19
 */
public class OrderIdShardingStrategy implements ShardingStrategy<String, String> {
    public String getDataSourceFactoryName(String orderId) {
        return "dsf" + orderId.substring(1, 2);
    }

    public String getTargetTable(String table, String orderId) {
        return table + "_" + orderId.substring(2, 3);
    }
}
