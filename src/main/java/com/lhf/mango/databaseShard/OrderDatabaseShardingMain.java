package com.lhf.mango.databaseShard;

import com.google.common.collect.Lists;
import com.lhf.mango.dao.DatabaseShardingOrderDao;
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
 * @ClassName: OrderDatabaseShardingMain
 * @Desc: 数据库分片通常也被称为分库，散库等。
 * 当我们在某个库中，把某张大表拆分成多个小表后还不能满足性能要求，这时我们需要把一部分拆分的表挪到另外一个库中，以提高sql执行效率。
 * 3个独立数据库db0，db1，db2中，各有1张t_order表，在读写t_order表时，我们按照用户ID（后续简称uid）纬度进行数据库分片：
 *
 * uid模3为0的请求落在数据库db0
 * uid模3为1的请求落在数据库db1
 * uid模3为2的请求落在数据库db2
 *
 * @Author: liuhefei
 * @Date: 2018/12/21 14:14
 */
public class OrderDatabaseShardingMain {
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

        DatabaseShardingOrderDao orderDao = mango.create(DatabaseShardingOrderDao.class);
        List<Integer> uids = Lists.newArrayList(1,2,3,4,5,6,7,8,9);
        for(Integer uid : uids){
            String id = RandomUtils.randomStringId(10);   //随机生成10位字符串ID
            Order order = new Order();
            order.setId(id);
            order.setUid(uid);
            order.setPrice(1000);
            order.setStatus(1);

            orderDao.addOrder(order); //插入订单
            System.out.println(orderDao.getOrdersByUid(uid));   //查看订单
        }
    }

}
