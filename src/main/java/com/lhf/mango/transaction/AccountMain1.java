package com.lhf.mango.transaction;

import com.lhf.mango.dao.AccountDao;
import com.lhf.mango.entity.Account;
import org.jfaster.mango.datasource.DriverManagerDataSource;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.transaction.Transaction;
import org.jfaster.mango.transaction.TransactionFactory;
import org.jfaster.mango.util.logging.MangoLogger;

import javax.sql.DataSource;

/**
 * @ClassName: AccountMain1
 * @Desc:  编程式事务
 * @Author: liuhefei
 * @Date: 2018/12/24 9:28
 */
public class AccountMain1 {

    public static void main(String[] args){
        MangoLogger.useLog4J2Logger(); // 使用log4j2输出日志，log4j2.xml文件在resources目录下

        //定义数据源
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mango_example?useSSL=false";
        String username = "root";
        String passowrd = "root";
        DataSource ds = new DriverManagerDataSource(driverClassName,url, username, passowrd);
        Mango mango = Mango.newInstance(ds);  //使用数据源初始化mango

        AccountDao accountDao = mango.create(AccountDao.class);
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setUid(3);
        account1.setName("小花");
        account1.setMoney(1500);
        accountDao.addAccount(account1);

       account2.setUid(4);
        account2.setName("小美");
        account2.setMoney(1500);
        accountDao.addAccount(account2);

       //转账前
        System.out.println("转账前：");
       System.out.println(accountDao.getAccount(1).toString());
       System.out.println(accountDao.getAccount(2).toString());

        //开启事务
        Transaction tx = TransactionFactory.newTransaction();
        int money = 1500;
        try{
            accountDao.transferMoney(1, -money);
            accountDao.transferMoney(2, money);
        }catch (Throwable e){
            tx.rollback();   //回滚
            return;
        }

        tx.commit();  //提交事务

        //转账后
        System.out.println("转账后：");
        System.out.println(accountDao.getAccount(1).toString());
        System.out.println(accountDao.getAccount(2).toString());
    }
}
