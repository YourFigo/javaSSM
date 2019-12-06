package cn.figo.service.impl;

import cn.figo.domain.Account;
import cn.figo.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Figo
 * @Date 2019/12/6 0:18
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户...");
        return null;
    }

    public void saveAccount(Account account) {
        System.out.println("业务层：保存帐户...");
    }
}
