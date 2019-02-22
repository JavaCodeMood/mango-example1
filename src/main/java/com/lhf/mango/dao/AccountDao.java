package com.lhf.mango.dao;

import com.lhf.mango.entity.Account;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

@DB
public interface AccountDao {

    @SQL("update account set money = money + :2 where uid = :1")
    boolean transferMoney(int uid, int inc);

    @SQL("select uid,name,money from account where uid =:1")
    Account getAccount(int uid);

    @SQL("insert into account(uid,name,money) values(:uid, :name, :money)")
    void addAccount(Account account);
}
