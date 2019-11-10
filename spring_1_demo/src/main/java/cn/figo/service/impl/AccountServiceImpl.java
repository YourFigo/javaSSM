package cn.figo.service.impl;

import cn.figo.dao.IAccountDao;
import cn.figo.factory.BeanFactory;
import cn.figo.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();

    private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");

    private int i = 1;

    public void  saveAccount(){
//        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
