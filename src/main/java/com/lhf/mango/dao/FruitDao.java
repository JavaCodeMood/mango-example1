package com.lhf.mango.dao;

import com.lhf.mango.entity.Fruit;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.crud.CrudDao;

import java.util.List;

@DB(table="fruit")
public interface FruitDao extends CrudDao<Fruit, Long> {
    String COLUMNS = "id, name, num, price, address";

    //插入数据
    @SQL("insert into #table(" + COLUMNS + ") values(:id, :name, :num, :price, :address)")
    public void add(Fruit fruit);

    //根据name取num的总和
    @SQL("select sum(num) from #table where name=:1")
    public int getTotalNum(String name);

    //查询所有水果
    @SQL("select " + COLUMNS + " from #table")
    List<Fruit> list();

    //根据水果id查询水果信息
    @SQL("select " + COLUMNS + " from #table where id = :1")
    Fruit getFruitByid(Long id);

    @SQL("select count(*) from #table")
    int countNum();
}
