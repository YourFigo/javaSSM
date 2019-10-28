package cn.figo.mybatis.sqlsession.proxy;

import cn.figo.mybatis.cfg.Mapper;
import cn.figo.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @Author Figo
 * @Date 2019/10/28 22:31
 * 用于创建代理对象时增强功能
 */
public class MapperProxy implements InvocationHandler {

    // map的key是全限定类名+方法名
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 用于对方法进行增强的，我们的增强其实就是调用selectList方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className + "." + methodName;
        Mapper mapper = mappers.get(key);
        if (mapper == null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        return new Executor().selectList(mapper,conn);
    }
}
