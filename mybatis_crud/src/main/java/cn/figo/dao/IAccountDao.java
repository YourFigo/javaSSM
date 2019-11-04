package cn.figo.dao;

import cn.figo.domain.Account;
import cn.figo.domain.AccountUser;

import java.util.List;

/**
 * @Author Figo
 * @Date 2019/11/3 14:45
 */
public interface IAccountDao {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();

    /**
     * 一对一延迟加载
     * @return
     */
    List<Account> findAllLazy();

    /**
     * 根据用户id查询账户信息，多对一延迟加载中用到
     * @return
     */
    List<Account> findAccountByUidLazy();
}
