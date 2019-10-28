package cn.figo.mybatis.io;

import java.io.InputStream;

/**
 * @Author Figo
 * @Date 2019/10/28 21:34
 * 使用类加载器读取配置文件的类
 */
public class Resources {

    /**
     * 根据传入的参数，获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
