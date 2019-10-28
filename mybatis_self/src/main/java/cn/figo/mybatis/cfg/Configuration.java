package cn.figo.mybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Figo
 * @Date 2019/10/28 21:58
 * 自定义mybatis的配置类
 */
public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;

    // 用于存放从映射xml中读取的 SQL语句和结果类型的全限定类名,key为 dao的全限定类名.方法名
    private Map<String,Mapper> mappers = new HashMap<String,Mapper>();

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    //此处需要使用追加的方式
    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
