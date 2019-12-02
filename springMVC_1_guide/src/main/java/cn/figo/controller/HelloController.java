package cn.figo.controller;

import cn.figo.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Figo
 * @Date 2019/11/30 23:31
 * 控制器类
 */
@Controller
@RequestMapping(path = "/user")
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello springMVC");
        return "success";
    }


    // method 限制请求的方式，如果请求方式不匹配也不会执行相关方法
    // method = {RequestMethod.POST,RequestMethod.GET}
    // params 限制请求中的参数，请求中不带该参数，则无法匹配控制器方法
    // params = {"username"} 请求中必须带有 username参数
    // params = {"username=haha"} 请求中必须带有username参数，并且参数值必须是 haha
    // 请求参数的绑定 请求中的参数名和控制器方法中的参数名相同，spring会自动封装数据


    @RequestMapping(path = "/testRequestMapping", method = {RequestMethod.POST,RequestMethod.GET},params = {"username=tom"},headers = {"accept"})
    public String testRequestMapping(String username){
        System.out.println("RequestMapping 注解");
        System.out.println(username);
        return "success";
    }

    @RequestMapping(path = "/testParams")
    public String testParams(Account account){
        System.out.println("参数绑定");
        System.out.println(account);
        return "success";
    }
}
