package cn.figo.test;

/**
 * @Author Figo
 * @Date 2019/11/26 21:30
 */

import cn.figo.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试AOP的配置
 */
public class AOPTest {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //3.执行方法
        as.saveAccount();
        System.out.println("--------------------");
        as.updateAccount(1);
        System.out.println("--------------------");
        as.deleteAccount();
    }
}
