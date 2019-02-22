package com.lhf.mango.tableShard;

import org.jfaster.mango.sharding.TableShardingStrategy;

/**
 * @ClassName: OrderTableShardingStrategy
 * @Desc: 实现表分片，需要实现TableShardingStrategy接口
 * getTargetTable方法是表分片策略的核心，共两个输入参数，输出则为最终需要访问的表名字，所以我们通过实现getTargetTable方法计算最终需要访问的表名字。
 *
 * 第1个参数table为@DB注解中table参数所定义的全局表名，这里是t_order。
 *
 * 第2个参数是自定义传入的参数，这里由于我们要使用uid计算如何分表，所以第2个参数是uid
 * @Author: liuhefei
 * @Date: 2018/12/21 11:29
 */
public class OrderTableShardingStrategy implements TableShardingStrategy<Integer> {

    /**
     * uid小于等于1000时，使用t_order_0表
     * uid大于1000时，时使用t_order_1表
     * @param table
     * @param uid
     * @return
     */
    public String getTargetTable(String table, Integer uid) {
        int num = uid <= 100 ? 0 : 1;
        return table + "_" + num;
    }
}
