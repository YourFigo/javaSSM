package cn.figo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author Figo
 * @Date 2019/11/26 23:24
 */
@Configuration
@ComponentScan(basePackages = "cn.figo")
@EnableAspectJAutoProxy //开启AOP
public class SpringConfiguration {
}
