package com.lhf.mango.dao;

import com.lhf.mango.entity.Teacher;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.invoker.function.IntegerListToStringFunction;

/**
 * @ClassName: TeacherDao
 * @Desc:
 * @Author: liuhefei
 * @Date: 2019/1/30 15:00
 */
@DB(table = "teacher")
public interface TeacherDao {

    @ReturnGeneratedId
    @SQL("insert into teacher(name, student_ids) values(:name, :studentIds) ")
    public int insertTeacher(Teacher teacher);

    @SQL("select id, name, student_ids from teacher where id = :1")
    public Teacher getTeacherById(Integer id);
}
