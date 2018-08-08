package shiro;

import com.kingdom.model.Menu;
import com.kingdom.model.Role;
import com.kingdom.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author No.1412
 * @version 2018/7/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-spring-context.xml")
public class RoleTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void saveRoleMenu() {
        Role role = new Role();
        List<Menu> menuList = Arrays
                .asList(new Menu(1)
                        , new Menu(2)
                        , new Menu(4)
                        , new Menu(6)
                        , new Menu(10));
//        List<Menu> menuList = new ArrayList<>();
        role.setMenuList(menuList);
        role.setId(6);
//        for (int i = 1; i <= 3; i++) {
//            menuList.add(new Menu(i));
//        }
        roleService.saveRoleMenu(role);
    }
}
