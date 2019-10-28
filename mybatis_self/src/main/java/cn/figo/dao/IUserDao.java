package cn.figo.dao;

import cn.figo.domain.User;
import cn.figo.mybatis.annotation.Select;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
