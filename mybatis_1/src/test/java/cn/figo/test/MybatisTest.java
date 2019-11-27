package cn.figo.test;

import cn.figo.dao.IUserDao;
import cn.figo.domain.User;
import cn.figo.domain.UserVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.BeanUtils;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis的入门案例
 * @Author Figo
 * @Date 2019/10/27 14:22
 */
public class MybatisTest {

    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args)throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            // 使用 BeanUtils 对vo类进行封装
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user,userVo);
            userVo.setNewField("new");
            System.out.println(userVo);
            //System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
