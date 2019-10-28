package cn.figo.mybatis.sqlsession;

/**
 * @Author Figo
 * @Date 2019/10/28 21:42
 *
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
