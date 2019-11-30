package cn.figo.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author Figo
 * @Date 2019/11/30 14:38
 * spring的主配置类
 */
@Configuration
@ComponentScan("cn.figo")
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("jdbcConfig.properties")
@EnableTransactionManagement
public class SpringConfiguration {
}
