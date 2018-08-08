package com.gtwm.web;

import com.kingdom.model.Menu;
import com.kingdom.model.User;
import com.kingdom.service.MenuService;
import com.kingdom.utils.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("${adminPath}")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MenuService menuService;

    @RequestMapping("login")
    public String login() {
        logger.info("进入登录页面");
        return "login";
    }

    @RequestMapping
    public String index() {
        logger.info("登录成功");
        return "reportList";
    }

    @ResponseBody
    @PostMapping("showMenus")
    public Menu showMenus() {
        return UserUtils.getMenuAll();
    }

//    private Object getCache(String key) {
//        return getSession().getAttribute(key);
//    }
//
//    private void putCache(String key, Object value) {
//        getSession().setAttribute(key, value);
//    }
//
//    private Session getSession() {
//        return SecurityUtils.getSubject().getSession();
//    }
//
//    public User getUser() {
//        Subject currentUser = SecurityUtils.getSubject();
//        User user = (User) currentUser.getPrincipal();
//        return user;
//    }
}
