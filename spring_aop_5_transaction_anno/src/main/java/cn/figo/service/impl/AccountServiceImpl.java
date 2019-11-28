package cn.figo.service.impl;

/**
 * @Author Figo
 * @Date 2019/11/19 21:01
 */

import cn.figo.dao.IAccountDao;
import cn.figo.domain.Account;
import cn.figo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount(acccountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5更新转出账户
        accountDao.updateAccount(source);

        /*
        这里的四个数据库操作，每次执行持久层的方法都是一个独立事务，因此无法进行事务控制
        这时，我们需要使用 ThreadLocal对象把Connection和当前线程绑定，从而使一个线程只有
        一个能控制事务的对象，实现事务的提交和回滚
         */

//        int i=1/0;

        //2.6更新转入账户
        accountDao.updateAccount(target);
    }
}

