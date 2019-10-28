package cn.figo.mybatis.sqlsession.defaults;

import cn.figo.mybatis.cfg.Configuration;
import cn.figo.mybatis.sqlsession.SqlSession;
import cn.figo.mybatis.sqlsession.proxy.MapperProxy;
import cn.figo.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author Figo
 * @Date 2019/10/28 22:24
 * SqlSession接口的实现类
 */
public class DefaultSqlSession implements SqlSession {

    // Configuration 对象中包括数据库信息和映射信息
    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        Class[] x = new Class[]{daoInterfaceClass};
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));
    }

    /**
     * 用于释放资源
     */
    @Override
    public void close() {
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
