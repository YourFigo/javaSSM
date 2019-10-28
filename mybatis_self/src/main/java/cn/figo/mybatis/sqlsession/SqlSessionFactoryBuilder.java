package cn.figo.mybatis.sqlsession;

import cn.figo.mybatis.cfg.Configuration;
import cn.figo.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import cn.figo.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @Author Figo
 * @Date 2019/10/28 21:40
 * 用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
