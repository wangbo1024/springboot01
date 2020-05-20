package com.thinkpad.springboot.controller;

import com.thinkpad.springboot.bean.User;
import com.thinkpad.springboot.dao.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    UserMapper userMapper;
    Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/hello")
    public String showIndex(Model model){
        /*logger.info("普通日志信息");
        logger.error("报错日志信息");*/
        List<User> users = userMapper.findAllUser();
        String htmlContent = "<p style='color:red'> 红色文字</p>";
        User currentProduct =new User(5,"product e", 200);
        boolean testBoolean = true;

        Date now = new Date();

        List<User> ps = new ArrayList<>();
        ps.add(new User(1,"product a", 50));
        ps.add(new User(2,"product b", 100));
        ps.add(new User(3,"product c", 150));
        ps.add(new User(4,"product d", 200));
        ps.add(currentProduct);
        ps.add(new User(6,"product f", 200));
        ps.add(new User(7,"product g", 200));

        model.addAttribute("now", now);
        model.addAttribute("ps", ps);
        model.addAttribute("htmlContent", htmlContent);
        model.addAttribute("currentProduct", currentProduct);
        model.addAttribute("testBoolean", testBoolean);
        model.addAttribute("name", "thymeleaf");
        model.addAttribute("users",users);
        return "hello";
    }
}
