package cn.figo.ui;

import cn.figo.factory.BeanFactory;
import cn.figo.service.IAccountService;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //IAccountService as = new AccountServiceImpl();
        for(int i=0;i<5;i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            // as.saveAccount();
        }

    }
}
