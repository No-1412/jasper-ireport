package shiro;

import com.kingdom.model.Menu;
import com.kingdom.model.User;
import com.kingdom.service.MenuService;
import com.kingdom.service.UserService;
import com.kingdom.utils.UserUtils;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author No.1412
 * @version 2018/7/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-context.xml"})
public class MenuTest {

    private final transient Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @Test
    public void saveMenu() {
        Menu menu = new Menu();
//        menu.setId(2);
        menu.setHref("/king/guillotine");
        menu.setName("墓場～ギロチン広場");
        menu.setIsShow(1);
        menu.setParentMenu(new Menu(1));
        menu.setParentIds("0,1");
        menu.setSort(50);
        saveUserInfo(menu);
        menuService.insert(menu);
        logger.info("保存菜单成功-> {}", menu.getName());
    }

    @Test
    public void update() {
        Menu menu = menuService.getById(3);
        menu.setSort(20);
        menu.setParentMenu(new Menu(2));
        menu.setHref("/king/void/home");
        menu.setName("梅林大师家");
        menu.setIsShow(1);
        menu.setParentIds("0,1,2");
//        menu.setRemarks("kingdom hearts");
        saveUserInfo(menu);
        menuService.updateByPrimaryKey(menu);
    }

    @Test
    public void getMenus() {
        Menu menu = new Menu();
        menu.setUserId("56");
        List<Menu> menuList = menuService.findByUserId(menu);
        System.out.println(menuList.size());
    }

    @Test
    public void getMenuAll() {
        Menu menu = generateMenu();
        System.out.println(menu);
    }

    @Test
    public void showMenu() {
        Menu menu = generateMenu();
        System.out.println(menu.getName());
        StringBuilder html = new StringBuilder();
        showMenu(menu, html);
        System.out.println(html.toString());
    }

    @Test
    public void getMenuByUserId() {
        Menu menu = UserUtils.getMenuAll();
        StringBuilder sb = new StringBuilder();
        showMenu(menu, sb);
        System.out.println(sb.toString());
    }

    private void showMenu(Menu menu, StringBuilder html) {
        if (CollectionUtils.isEmpty(menu.getChildMenus())) return;
        html.append("<ul>");
        for (Menu m : menu.getChildMenus()) {
            System.out.println(m.getName());
            if (CollectionUtils.isEmpty(m.getChildMenus()))
                html.append("<a>");
            html.append("<li><span>").append(m.getName()).append("</span>");
            showMenu(m, html);
            html.append("</li>");
            if (CollectionUtils.isEmpty(m.getChildMenus()))
                html.append("</a>");
        }
        html.append("</ul>");
    }

    private Menu generateMenu() {
        Menu menu = new Menu();
        menu.setUserId("56");
        List<Menu> menuList = menuService.findByUserId(menu);
        Menu parentMenu = new Menu();
        for (Menu m : menuList) {
            if (m.getParentMenu().getId().equals(0)) {
                BeanUtils.copyProperties(m, parentMenu);
                autoAssembleMenus(menuList, parentMenu);break;
            }
        }
        return parentMenu;
    }

    private void autoAssembleMenus(List<Menu> menuList, Menu parentMenu) {
        for (Menu menu : menuList) {
            if (parentMenu.getId().equals(menu.getParentMenu().getId())) {
                if (parentMenu.getChildMenus() == null)
                    parentMenu.setChildMenus(new ArrayList<>());
                parentMenu.getChildMenus().add(menu);
                menu.setParentMenu(parentMenu);
                autoAssembleMenus(menuList, menu);
            }
        }
    }

    private void saveUserInfo(Menu menu) {
        User user = userService.getById(56);
        menu.setCreateBy(user.getId().toString());
        menu.setCreateTime(new Date());
        menu.setUpdateBy(user.getId().toString());
        menu.setUpdateTime(new Date());
    }
}
