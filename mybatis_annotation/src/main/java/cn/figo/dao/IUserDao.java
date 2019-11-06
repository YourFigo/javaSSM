package cn.figo.dao;

import cn.figo.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Figo
 * @Date 2019/11/6 23:07
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
