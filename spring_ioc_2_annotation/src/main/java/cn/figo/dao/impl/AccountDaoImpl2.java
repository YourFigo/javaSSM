package cn.figo.dao.impl;

import cn.figo.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 * @Author Figo
 * @Date 2019/11/18 23:10
 */
@Repository("accountDao2")
public class AccountDaoImpl2  implements IAccountDao {

    public  void saveAccount(){

        System.out.println("保存了账户2222222222222");
    }
}
