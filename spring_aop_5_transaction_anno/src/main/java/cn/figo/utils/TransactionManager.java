package cn.figo.utils;

/**
 * @Author Figo
 * @Date 2019/11/20 22:00
 */


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 是 AOP中的通知类
 * 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 */
@Component("txManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* cn.figo.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 开启事务
     */
    public  void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public  void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public  void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 释放连接
     */
    public  void release(){
        try {
            connectionUtils.getThreadConnection().close();//还回连接池中
            connectionUtils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 由于最终通知和后置通知的顺序问题，
    // 最终通知先执行，释放连接，然后再执行后置通知，因此无法完成事务控制，
    // 需要使用环绕通知
    /**
     * 环绕通知
     */
    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();//得到方法执行所需的参数

            // 开启事务
            this.beginTransaction();
            // 执行方法
            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）
            // 提交事务
            this.commit();

            return rtValue;
        }catch (Throwable t){
            // 回滚事务
            this.rollback();
            throw new RuntimeException(t);
        }finally {
            // 释放连接
            this.release();
        }
    }
}

