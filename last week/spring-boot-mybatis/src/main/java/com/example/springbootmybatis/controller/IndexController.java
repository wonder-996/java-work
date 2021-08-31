package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
//去login页面
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login" ;
    }
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getUserName())&&StringUtils.hasLength(user.getPassword()))
        {//储存登录成功的用户
            session.setAttribute("loginUser",user);
            //登陆成功到
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }

    }
//去main页面
@GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
/*Object loginUser=session.getAttribute("loginUser");
if (loginUser!=null){
        return "main";
}else {
    model.addAttribute("msg","重新登录");*/
    return "main";

}
}
