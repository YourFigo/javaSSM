package cn.figo.test;

import cn.figo.dao.IUserDao;
import cn.figo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Author Figo
 * @Date 2019/11/3 15:14
 */
public class UserTest {


    private InputStream in;
    SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        // factory.openSession(true) 参数为 true，表示自动提交事务
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        // sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试user一对多查询所有
     */
    @Test
    public void testFindUserAccount(){
        List<User> users = userDao.findUserAccount();
        for(User user : users){
            System.out.println("--------每个user的信息------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }


    /**
     * 测试user一对多 根据id查询
     */
    @Test
    public void testFindUserAccountById(){
        User user = userDao.findUserAccountById(45);
        System.out.println(user);
        System.out.println(user.getAccounts());
    }

    /**
     * 测试多对多查询所有 user
     */
    @Test
    public void testFindUserRole(){
        List<User> users = userDao.findUserRole();
        for(User user : users){
            System.out.println("-----每个用户的信息------");
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

    /**
     * 测试user一对多查询所有 延迟加载
     */
    @Test
    public void testFindAllLazyMulti(){
        List<User> users = userDao.findAllLazyMulti();
        for(User user : users){
            System.out.println("--------每个user的信息------------");
            System.out.println(user);
            // 这里先执行 Preparing: select * from user;  后执行 select * from account where uid = ?
            // 如果这里不使用 user.getAccounts()，那么就不会执行 select * from account where uid = ?
            // 这就是延迟加载
            System.out.println(user.getAccounts());
        }
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache(){
        User user1 = userDao.findById(41);
        System.out.println(user1);

        //sqlSession.close();
        //再次获取SqlSession对象
        //sqlSession = factory.openSession();

        sqlSession.clearCache();//此方法也可以清空缓存

        userDao = sqlSession.getMapper(IUserDao.class);

        User user2 = userDao.findById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }

    /**
     * 测试缓存的同步
     */
    @Test
    public void testClearlCache(){
        //1.根据id查询用户
        User user1 = userDao.findById(41);
        System.out.println(user1);

        //2.更新用户信息
        user1.setUserName("update user clear cache");
        user1.setUserAddress("北京市海淀区");
        userDao.updateUser(user1);

        //3.再次查询id为41的用户
        User user2 = userDao.findById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void testSecondLevelCache(){
        SqlSession sqlSession1 = factory.openSession();
        IUserDao dao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = dao1.findById(41);
        System.out.println(user1);
        sqlSession1.close();//一级缓存消失

        SqlSession sqlSession2 = factory.openSession();
        IUserDao dao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = dao2.findById(41);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println(user1 == user2);
    }
}
