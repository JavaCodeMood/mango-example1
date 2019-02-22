package com.lhf.mango.MultiDimenShard;

import com.google.common.collect.Lists;
import com.lhf.mango.dao.MultiDimenShardingOrderDao;
import com.lhf.mango.entity.Order;
import com.lhf.mango.util.RandomUtils;
import org.jfaster.mango.datasource.DataSourceFactory;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.datasource.SimpleDataSourceFactory;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.util.logging.MangoLogger;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MultiDimenShardMain
 * @Desc: 多维度分片策略    分表分库
 * @Author: liuhefei
 * @Date: 2018/12/21 16:01
 */
public class MultiDimenShardMain {

    public static void main(String[] args){
        MangoLogger.useLog4J2Logger(); // 使用log4j2输出日志，log4j2.xml文件在resources目录下

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

        MultiDimenShardingOrderDao orderDao = mango.create(MultiDimenShardingOrderDao.class);

        Order order = new Order();

        List<Integer> uids = Lists.newArrayList(10,11,12,13,14,16,30007,30008,30009,30010,30011,30012);
        for(Integer uid : uids){
            String randomId = RandomUtils.randomStringId(10);   //随机生成10位字符串ID
            String holderMark = "1";  //订单ID首位永远为1，避免为0
            String databaseMark = uid % 3 + "";
            String tableMark = uid <= 1000 ? "0" : "1";
            String id = holderMark + databaseMark + tableMark + randomId;  //拼接ID

            order.setId(id);
            order.setUid(uid);
            order.setPrice(1000);
            order.setStatus(1);

            orderDao.addOrder(order);
            System.out.println(orderDao.getOrdersByUid(uid));
            System.out.println(orderDao.getOrderById(id));
        }
    }

}
