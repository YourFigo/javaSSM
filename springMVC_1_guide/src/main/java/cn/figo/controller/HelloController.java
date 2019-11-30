package cn.figo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Figo
 * @Date 2019/11/30 23:31
 * 控制器类
 */
@Controller
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello springMVC");
        return "success";
    }
}
