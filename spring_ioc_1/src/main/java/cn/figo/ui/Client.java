package cn.figo.ui;

import cn.figo.dao.IAccountDao;
import cn.figo.service.IAccountService;
import cn.figo.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     *  ApplicationContext 的三个常用实现类：
     *       ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)
     *       FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
     *       AnnotationConfigApplicationContext：它是用于读取注解创建容器的，是明天的内容。
     *
     *  核心容器的两个接口：
     *   ApplicationContext:     单例对象适用 ,实际开发通常采用此接口
     *       它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
     *   BeanFactory:            多例对象使用
     *       它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
     */

    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
/*        // 获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 根据id获取bean对象
        IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao");
        System.out.println(accountDao);
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        IAccountService accountService2 = (IAccountService) ac.getBean("accountService");
        System.out.println(accountService);
        System.out.println(accountService2);
        System.out.println(accountService == accountService2);*/

//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        IAccountService as = (IAccountService) factory.getBean("accountService");
//        System.out.println(as);


        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService accountService = (IAccountService) ac.getBean("accountService");

//        IAccountService accountService = (IAccountService) ac.getBean("accountService1");
//        IAccountService accountService = (IAccountService) ac.getBean("accountService2");
        IAccountService accountService = (IAccountService) ac.getBean("accountService3");

        accountService.saveAccount();
        System.out.println(accountService);
        ac.close();
    }
}
