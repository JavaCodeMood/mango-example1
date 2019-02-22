package com.lhf.mango.Sharding;

import com.google.common.collect.Lists;
import com.lhf.mango.dao.ShardingOrderDao;
import com.lhf.mango.entity.Order;
import com.lhf.mango.util.RandomUtils;
import org.jfaster.mango.datasource.DataSourceFactory;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.datasource.SimpleDataSourceFactory;
import org.jfaster.mango.operator.Mango;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ShardingMain
 * @Desc: 同时实现分表分库操作, 属于一维分片策略
 *
 * uid模3为0且小于等于1000时，使用db0中的t_order_0表
 * uid模3为1且小于等于1000时，使用db1中的t_order_0表
 * uid模3为2且小于等于1000时，使用db2中的t_order_0表
 * uid模3为1且大于1000时，使用db0中的t_order_1表
 * uid模3为1且大于1000时，使用db1中的t_order_1表
 * uid模3为1且大于1000时，使用db2中的t_order_1表
 *
 * @Author: liuhefei
 * @Date: 2018/12/21 15:10
 */
public class ShardingMain {

    public static void main(String[] args){
        String driverClassName = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "root";

        int dbCount = 3;
        //初始化数据源工厂
        /**
         * 名字为dsf0的数据源工厂连接数据库mongo_example0
         * 名字为dsf1的数据源工厂连接数据库mongo_example1
         * 名字为dsf2的数据源工厂连接数据库mongo_example2
         */
        List<DataSourceFactory> dsfs = new ArrayList<DataSourceFactory>();
        for(int i=0;i<dbCount;i++){
            String name = "dsf" + i;
            String url = "jdbc:mysql://localhost:3306/mango_example" + i + "?useSSL=false";
            System.out.println("name = " + name + "  url = " + url);
            DataSource ds = new DriverManagerDataSource(driverClassName, url, username, password);
            DataSourceFactory dsf = new SimpleDataSourceFactory(name, ds);
            dsfs.add(dsf);
        }
        Mango mango = Mango.newInstance(dsfs);

        ShardingOrderDao orderDao = mango.create(ShardingOrderDao.class);
        List<Integer> uids = Lists.newArrayList(1,2,3,4,5,6,30001,30002,30003,30004,30005,30006);
        for(Integer uid : uids){
            String id = RandomUtils.randomStringId(10);  //随机生成10位随机数
            Order order = new Order();
            order.setId(id);
            order.setUid(uid);
            order.setPrice(1000);
            order.setStatus(1);

            orderDao.addOrder(order);
            System.out.println(orderDao.getOrderByUid(uid));
        }
    }

}
