package cn.figo.dao.impl;

/**
 * @Author Figo
 * @Date 2019/11/18 23:00
 */

import cn.figo.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {

    public  void saveAccount(){

        System.out.println("保存了账户1111111111111");
    }
}
