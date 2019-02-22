package com.lhf.mango.MultiDimenShard;

import org.jfaster.mango.sharding.ShardingStrategy;

/**
 * @ClassName: OrderUidShardingStrategy
 * @Desc: 分表 + 分库
 * @Author: liuhefei
 * @Date: 2018/12/21 16:19
 */
public class OrderUidShardingStrategy implements ShardingStrategy<Integer, Integer> {

    public String getDataSourceFactoryName(Integer uid) {
        return "dsf" + uid % 3;
    }

    public String getTargetTable(String table, Integer uid) {
        int num = uid <= 1000 ? 0 : 1;
        return table + "_" + num;
    }
}
