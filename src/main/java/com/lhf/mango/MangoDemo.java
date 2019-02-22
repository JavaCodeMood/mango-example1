package com.lhf.mango;

import com.lhf.mango.dao.FruitDao;
import com.lhf.mango.entity.Fruit;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.util.logging.MangoLogger;

import javax.sql.DataSource;

/**
 * @ClassName: MangoDemo
 * @Desc: mango的中文名是“芒果”，它是一个极速分布式ORM框架。
 * 实现增删改查操作，这里也是操作单一数据库实例
 * @Author: liuhefei
 * @Date: 2018/12/20 15:23
 */
public class MangoDemo {
    //定义数据源
    String driverClassName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/mango_example";
    String username = "root";
    String passowrd = "root";
    DataSource ds = new DriverManagerDataSource(driverClassName,url, username, passowrd);
    Mango mango = Mango.newInstance(ds);  //使用数据源初始化mango

    public static void main(String[] args){
        MangoLogger.useConsoleLogger();   //在控制台输出日志

        MangoDemo mangoDemo = new MangoDemo();
        //添加水果
        mangoDemo.add("苹果", 100, 5.8, "云南昆明");
        mangoDemo.add("香蕉", 200, 3.6, "云南西双版纳");
        mangoDemo.add("雪梨", 340, 8.8, "天山");
        mangoDemo.add("葡萄", 130, 6.4, "新疆吐鲁番");

        mangoDemo.getTotalNum("苹果");

        mangoDemo.list();

        mangoDemo.getFruitByid(3);

        System.out.println("总数："+mangoDemo.countNum());
    }

    public void add(String name, int num, double price, String address){
        FruitDao fruitDao = mango.create(FruitDao.class);
        Fruit fruit = new Fruit();
        fruit.setName(name);
        fruit.setNum(num);
        fruit.setPrice(price);
        fruit.setAddress(address);
        fruitDao.add(fruit);
    }

    public void getTotalNum(String name){
        FruitDao fruitDao = mango.create(FruitDao.class);
        int num = fruitDao.getTotalNum(name);
        System.out.println(name + "的num是： " + num);
    }

    public void list(){
        FruitDao fruitDao = mango.create(FruitDao.class);
        String fruitList = fruitDao.list().toString();
        System.out.println("fruitList = " + fruitList);
    }

    public void getFruitByid(long id){
        FruitDao fruitDao = mango.create(FruitDao.class);
        String fruit = fruitDao.getFruitByid(id).toString();
        System.out.println("fruit = " + fruit);
    }

    public int countNum(){
        FruitDao fruitDao = mango.create(FruitDao.class);
        int num = fruitDao.countNum();
        return  num;
    }

}
