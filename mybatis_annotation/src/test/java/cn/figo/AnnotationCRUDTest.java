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
import java.util.Date;
import java.util.List;

/**
 * @Author Figo
 * @Date 2019/11/6 23:12
 */
public class AnnotationCRUDTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public  void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public  void destroy() throws  Exception{
        session.commit();
        session.close();
        in.close();
    }


    /*@Test
    public void testSave(){
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("北京市昌平区");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(53);
        user.setUsername("mybatis annotation update");
        user.setAddress("北京市海淀区");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }*/

    @Test
    public void testDelete(){
        userDao.deleteUser(51);
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(53);
        System.out.println(user);

        User user2 = userDao.findById(53);
        System.out.println(user2);

        // 一级缓存默认是开启的
        System.out.println(user == user2);
    }

    /**
     * 二级缓存
     */
    @Test
    public void testFindOneSecondCache(){
        SqlSession session1 = factory.openSession();
        IUserDao userDao1 = session1.getMapper(IUserDao.class);
        User user = userDao1.findById(53);
        System.out.println(user);
        session1.close();

        SqlSession session2 = factory.openSession();
        IUserDao userDao2 = session2.getMapper(IUserDao.class);
        User user2 = userDao2.findById(53);
        System.out.println(user2);
        session2.close();

        // 二级缓存 需要配置
        // 二级缓存 存的是数据，而不是对象
        System.out.println(user == user2);
    }

    @Test
    public  void testFindByName(){
        List<User> users = userDao.findUserByName("%mybatis%");
//        List<User> users = userDao.findUserByName("mybatis");
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public  void testFindTotal(){
        int total = userDao.findTotalUser();
        System.out.println(total);
    }
}
