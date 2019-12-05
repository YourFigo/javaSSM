package cn.figo.service;

import cn.figo.domain.Account;

import java.util.List;

/**
 * @Author Figo
 * @Date 2019/12/6 0:17
 */
public interface AccountService {

    // 查询所有账户
    public List<Account> findAll();

    // 保存帐户信息
    public void saveAccount(Account account);

}
