package cn.figo.test;

import cn.figo.dao.IAccountDao;
import cn.figo.dao.IUserDao;
import cn.figo.domain.Account;
import cn.figo.domain.AccountUser;
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
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
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
}
