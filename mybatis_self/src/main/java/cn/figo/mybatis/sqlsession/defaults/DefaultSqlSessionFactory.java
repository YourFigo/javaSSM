package cn.figo.mybatis.sqlsession.defaults;

import cn.figo.mybatis.cfg.Configuration;
import cn.figo.mybatis.sqlsession.SqlSession;
import cn.figo.mybatis.sqlsession.SqlSessionFactory;

import java.util.Collections;

/**
 * @Author Figo
 * @Date 2019/10/28 22:19
 * SqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }
    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
