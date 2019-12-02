package cn.figo.controller;

import cn.figo.domain.Account;
import cn.figo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @Author Figo
 * @Date 2019/11/30 23:31
 * 控制器类
 */
/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value={"msg"})   // 把msg=美美存入到session域对中
public class AnnoController {

    /**
     * 把请求中的指定名称的参数传递给控制器中的形参赋值
     * @param username
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name="name") String username){
        System.out.println("执行了...");
        System.out.println(username);
        return "success";
    }


    /**
     * 获取请求体的内容
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了...");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     * @return
     */
    @RequestMapping(value="/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name="sid") String id){
        System.out.println("执行了...");
        System.out.println(id);
        return "success";
    }

    /**
     * post 请求：保存
     * @param user
     * @return
     */
    @RequestMapping(value="/testRestPOST",method=RequestMethod.POST)
    public String testRestfulURLPOST(User user){
        System.out.println("rest post"+user);
        return "success";
    }

    /**
     * put 请求：更新
     * @param id
     * @param user
     * @return
     */
    @RequestMapping(value="/testRestPUT/{id}",method=RequestMethod.PUT)
    public String testRestfulURLPUT(@PathVariable("id")Integer id,User user){
        System.out.println("rest put "+id+","+user);
        return "success";
    }

    /**
     * DELETE 请求：删除
     * @param id
     * @return
     */
    @RequestMapping(value="/testRestDELETE/{id}",method=RequestMethod.DELETE)
    public String testRestfulURLDELETE(@PathVariable("id")Integer id){
        System.out.println("rest delete "+id);
        return "success";
    }

    /**
     * GET 请求：查询
     * @param id
     * @return
     */
    @RequestMapping(value="/testRestGET/{id}",method=RequestMethod.GET)
    public String testRestfulURLGET(@PathVariable("id")Integer id){
        System.out.println("rest get "+id);
        return "success";
    }

    /**
     * 获取请求头的值
     * @param header
     * @return
     */
    @RequestMapping(value="/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value="Accept") String header, HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("执行了...");
        System.out.println(header);
         return "success";
    }

    /**
     * 获取Cookie的值
     * @return
     */
    @RequestMapping(value="/testCookieValue")
    public String testCookieValue(@CookieValue(value="JSESSIONID") String cookieValue){
        System.out.println("执行了...");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     * @return
     */
    @RequestMapping(value="/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了...");
        System.out.println(user);
        return "success";
    }

    /**
     * 有返回值的情况
     * @ModelAttribute 修饰的方法会先执行
     * @param uname
     * @param map
     * @return
     */
    /*@ModelAttribute
    public User showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行了...");
        // 通过用户查询数据库（模拟）
        // 前端传来的数据不完整时，其他属性默认用数据库中的属性值
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }*/

    /**
     * 没有返回值的情况
     * @param uname
     * @param map
     */
    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行了...");
        // 通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(50);
        user.setDate(new Date());
        // 没有返回值，存到 map中，控制器通过在参数前加@ModelAttribute("abc")注解拿到map
        map.put("abc",user);
    }

    /**
     * SessionAttributes的注解
     * Model 是 spring 提供的一个接口，该接口有一个实现类 ExtendedModelMap
     * 该类继承了 ModelMap，而 ModelMap 就是 LinkedHashMap 子类
     * @param model
     * @return
     */
    @RequestMapping(value="/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes...");
        // 底层会存储到request域对象中
        //跳转之前将数据保存到 username、 password 和 age 中，因为注解@SessionAttribute 中有这几个参数
        model.addAttribute("msg","美美");
        return "success";
    }

    /**
     * 获取值
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除
     * @param status
     * @return
     */
    @RequestMapping(value="/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("getSessionAttributes...");
        status.setComplete();
        return "success";
    }

}
