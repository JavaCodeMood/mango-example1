package com.lhf.mango.entity;

import org.jfaster.mango.annotation.Getter;
import org.jfaster.mango.annotation.Setter;
import org.jfaster.mango.invoker.function.IntegerListToStringFunction;
import org.jfaster.mango.invoker.function.StringToIntegerListFunction;

import java.util.List;

/**
 * @ClassName: Teacher
 * @Desc:  老师表，老师与学生的关系是一对多
 * @Author: liuhefei
 * @Date: 2019/1/30 14:50
 */
public class Teacher {
    private Integer id;

    private String name;

    private List<Integer> studentIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Getter(IntegerListToStringFunction.class)   //将整型列表转化为字符串
    public List<Integer> getStudentIds() {
        return studentIds;
    }

    @Setter(StringToIntegerListFunction.class)  //将字符串转化整型列表
    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }
}
