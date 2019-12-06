package cn.figo.service.impl;

import cn.figo.dao.AccountDao;
import cn.figo.domain.Account;
import cn.figo.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Figo
 * @Date 2019/12/6 0:18
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户...");
        List<Account> list = null;
        try {
            list = accountDao.findAll();
        }catch (Exception e){
            logger.info("查询异常 ...");
        }
        logger.info("查询正常 ...");
        return list;
    }

    public void saveAccount(Account account) {
        System.out.println("业务层：保存帐户...");
        try {
            accountDao.saveAccount(account);
        }catch (Exception e){
            logger.info("保存异常 ...");
        }
        logger.info("保存正常 ...");
    }
}
