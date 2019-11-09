package cn.figo;

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
 * @Date 2019/11/9 19:55
 */
public class UserTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public  void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public  void destroy()throws  Exception{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public  void  testFindAllUserAccount(){
        List<User> users = userDao.findAllUserAccount();
        for(User user : users){
            System.out.println("---每个用户的信息----");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
}

