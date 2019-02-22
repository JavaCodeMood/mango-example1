package com.lhf.mango.transaction;

import com.lhf.mango.dao.AccountDao;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.transaction.TransactionAction;
import org.jfaster.mango.transaction.TransactionStatus;
import org.jfaster.mango.transaction.TransactionTemplate;
import org.jfaster.mango.util.logging.MangoLogger;

import javax.sql.DataSource;

/**
 * @ClassName: AccountMain2
 * @Desc:  使用Mango的TransactionTemplate 进行事务控制
 * @Author: liuhefei
 * @Date: 2018/12/24 9:28
 */
public class AccountMain2 {

    public static void main(String[] args){
        MangoLogger.useLog4J2Logger(); // 使用log4j2输出日志，log4j2.xml文件在resources目录下

        //定义数据源
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example?useSSL=false";
        String username = "root";
        String passowrd = "root";
        DataSource ds = new DriverManagerDataSource(driverClassName,url, username, passowrd);
        Mango mango = Mango.newInstance(ds);  //使用数据源初始化mango
        final AccountDao accountDao = mango.create(AccountDao.class);

        //转账前
        System.out.println("转账前：");
        System.out.println(accountDao.getAccount(3).toString());
        System.out.println(accountDao.getAccount(4).toString());


        final int money = 1000;
        if(accountDao.getAccount(3).getMoney() > money){
            TransactionTemplate.execute(new TransactionAction() {
                public void doInTransaction(TransactionStatus transactionStatus) {
                    accountDao.transferMoney(3, -money);   //减去
                    accountDao.transferMoney(4, money);    //加上
                }
            });
        }else{
            System.out.println("余额不足，转账失败");
        }

        //转账后
        System.out.println("转账后：");
        System.out.println(accountDao.getAccount(3).toString());
        System.out.println(accountDao.getAccount(4).toString());

    }
}
