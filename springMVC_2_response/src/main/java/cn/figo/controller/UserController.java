package cn.figo.controller;

import cn.figo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Figo
 * @Date 2019/12/3 20:15
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回 String 类型的值
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法");
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(30);
        // model对象，底层会存储到request域对象中
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 没有返回值,RequestMapping中的值是什么，就返回该jsp
     * 这里默认返回 testVoid.jsp 没有这个页面会报404
     * @param model
     */
//    @RequestMapping("/testVoid")
    public void testVoid(Model model){
        System.out.println("testString方法");
    }

    /**
     * 基于上面的情况，我们可以转发的别的页面，也可以直接响应数据
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了...");
        // 编写请求转发的程序
        // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 重定向
        // response.sendRedirect(request.getContextPath()+"/index.jsp");

        // 设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 直接会进行响应
        response.getWriter().print("你好");

        return;
    }

    /**
     * 返回值是 ModelAndView
     * ModelAndView对象是Spring提供的一个对象，可以用来调整具体的JSP视图
     * @param model
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(Model model){
        System.out.println("testModelAndView方法");

        ModelAndView mv = new ModelAndView();

        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(30);

        // 把user对象存到mv对象中，也会把user存入request对象
        mv.addObject("user",user);
        // 跳转到哪个页面，跳转前可以使用视图解析器
        mv.setViewName("success");
        return mv;
    }

    /**
     * SpringMVC框架提供的转发和重定向
     * @param model
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(Model model){
        System.out.println("testForwardOrRedirect 方法");

        // return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     * 将请求体字符串封装为bean对象，需要jar包
     * @ResponseBody 将对象转为json响应到前端
     * @RequestBody 接收前端的请全体字符串转换为bean对象
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了...");
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        // 做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        // 做响应
        return user;
    }
}
