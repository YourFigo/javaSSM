package cn.figo.test;

/**
 * @Author Figo
 * @Date 2019/11/19 21:01
 */

import cn.figo.config.SpringConfiguration;
import cn.figo.domain.Account;
import cn.figo.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 * spring和junit的整合
 * 测试类中，没有Ioc容器，因此就算写了Autowired注解也无法注入数据，
 * 因此需要整合spring和junit
 *
 * 1、导入spring整合junit的jar(坐标)
 *  2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *  @Runwith
 *  3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *  @ContextConfiguration
 *      locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *      classes：指定注解类所在地位置
 *  当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:bean.xml")
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll() {
        /*ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService as = ac.getBean("accountService",IAccountService.class);*/
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("cn/figo/test");
        account.setMoney(12345f);
        //3.执行方法
        as.saveAccount(account);

    }

    @Test
    public void testUpdate() {
        //3.执行方法
        Account account = as.findAccountById(5);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //3.执行方法
        as.deleteAccount(4);
    }

}

