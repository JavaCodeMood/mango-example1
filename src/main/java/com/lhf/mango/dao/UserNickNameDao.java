package com.lhf.mango.dao;

import com.lhf.mango.entity.UserNickName;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

/**
 * @ClassName: UserNickNameDao
 * @Desc:  用户昵称接口
 * @Author: liuhefei
 * @Date: 2018/12/28 9:18
 */
@DB(table = "user_nickname")
public interface UserNickNameDao {

    @ReturnGeneratedId
    @SQL("insert into #table(nickname) values (:1.nickname)")
    public int insertNickName(UserNickName userNickName);
}
