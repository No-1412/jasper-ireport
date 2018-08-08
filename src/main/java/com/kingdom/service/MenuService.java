package com.kingdom.service;

import com.kingdom.dao.MenuDao;
import com.kingdom.model.Menu;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author No.1412
 * @version 2018/7/10
 */
@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    public void deleteById(Integer id) {
        menuDao.deleteByPrimaryKey(id);
    }

    public void insert(Menu menu) {
        menuDao.insert(menu);
    }

    public Menu getById(Integer id) {
        return menuDao.selectByPrimaryKey(id);
    }

    public void updateByPrimaryKey(Menu menu) {
        menuDao.updateByPrimaryKey(menu);
    }

    public List<Menu> findByUserId(Menu menu) {
        return menuDao.findByUserId(menu);
    }

    /**
     * 递归组装当前用户下
     * 所有菜单
     * @param userId
     */
    public Menu getAllByUserId(Integer userId) {
        return generateMenu(userId.toString());
    }

    private Menu generateMenu(String userId) {
        Menu menu = new Menu();
        menu.setUserId(userId);
        List<Menu> menuList = findByUserId(menu);
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
}
