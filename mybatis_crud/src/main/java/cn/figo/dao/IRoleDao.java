package cn.figo.dao;

import cn.figo.domain.Role;

import java.util.List;

/**
 * @Author Figo
 * @Date 2019/11/3 17:29
 */
public interface IRoleDao {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
