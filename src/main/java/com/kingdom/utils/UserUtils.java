package com.kingdom.utils;

import com.kingdom.model.Menu;
import com.kingdom.model.User;
import com.kingdom.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @author No.1412
 * @version 2018/7/19
 */
//@Component
//@Lazy(value = false)
public class UserUtils {

    private static final String CACHE_MENU_LIST = "menuList";

    private static MenuService menuService = (MenuService) com.kingdom.utils.SpringContextHolder.getApplicationContext().getBean("menuService");

    private static String test = new String();

//    @Autowired
//    public void setMenuService(MenuService menuService) {
//        this.menuService = menuService;
//    }

    /**
     * 获取当前用户
     * 下的所有权限
     */
    public static Menu getMenuAll() {
        test = "威斯克";
        Menu menu = (Menu) getCache(CACHE_MENU_LIST);
        if (menu == null) {
            menu = menuService.getAllByUserId(getUser().getId());
            putCache(CACHE_MENU_LIST, menu);
        }
        return menu;
    }

    private static Object getCache(String key) {
        return getSession().getAttribute(key);
    }

    private static void putCache(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    private static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static User getUser() {
        Subject currentUser = SecurityUtils.getSubject();
        User user = (User) currentUser.getPrincipal();
        return user;
    }
}
