package cn.figo.service.impl;

/**
 * @Author Figo
 * @Date 2019/11/26 21:28
 */


import cn.figo.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新"+i);

    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
