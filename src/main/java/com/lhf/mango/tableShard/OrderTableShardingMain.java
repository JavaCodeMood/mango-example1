package com.lhf.mango.tableShard;

import com.google.common.collect.Lists;
import com.lhf.mango.dao.TableShardingOrderDao;
import com.lhf.mango.entity.Order;
import com.lhf.mango.util.RandomUtils;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.List;

/**
 * @ClassName: OrderTableShardingMain
 * @Desc: 实现表分片
 * @Author: liuhefei
 * @Date: 2018/12/21 11:36
 */
public class OrderTableShardingMain {

    public static void main(String[] args){

        //定义数据源
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example?useSSL=false";
        String username = "root";
        String passowrd = "root";
        DataSource ds = new DriverManagerDataSource(driverClassName,url, username, passowrd);
        Mango mango = Mango.newInstance(ds);  //使用数据源初始化mango
        TableShardingOrderDao tableShardingOrderDao = mango.create(TableShardingOrderDao.class);

        Order order = new Order();

        List<Integer> uids = Lists.newArrayList(1, 2, 10020, 10086);
        for (Integer uid : uids) {
            String id = RandomUtils.randomStringId(10); // 随机生成10位字符串ID
            order.setId(id);
            order.setUid(uid);
            order.setPrice(100);
            order.setStatus(1);
            tableShardingOrderDao.addOrder(order);
            System.out.println(tableShardingOrderDao.getOrdersByUid(uid));
        }
    }


}
