package com.lhf.mango.Sharding;

import org.jfaster.mango.sharding.TableShardingStrategy;

/**
 * @ClassName: TableShardingStrategy
 * @Desc:  数据表分片策略
 *要实现数据表分片策略，需要实现实现了 TableShardingStrategy 接口中的 getTargetTable 方法。
 * getTargetTable方法是表分片策略的核心，共两个输入参数，输出则为最终需要访问的表名字，所以我们通过实现getTargetTable方法计算最终需要访问的表名字。
 *
 * 第1个参数table为@DB注解中table参数所定义的全局表名，这里是t_order。
 *
 * 第2个参数是自定义传入的参数，这里由于我们要使用uid计算如何分表，所以第2个参数是uid
 * @Author: liuhefei
 * @Date: 2018/12/21 15:20
 */
public class OrderTableShardingStrategy implements TableShardingStrategy<Integer> {
    /**
     * uid小于等于1000时，使用t_order_0表
     * uid大于1000时，时使用t_order_1表
     * @param table  表名
     * @param uid   分表参数
     * @return
     */
    public String getTargetTable(String table, Integer uid) {
        int num = uid <= 1000 ? 0 : 1;
        return table + "_" + num;
    }
}
