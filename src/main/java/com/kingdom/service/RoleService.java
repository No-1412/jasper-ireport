package com.kingdom.service;

import com.kingdom.dao.RoleDao;
import com.kingdom.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author No.1412
 * @version 2018/7/12
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 保存权限菜单中间表
     */
    public void saveRoleMenu(Role role) {
        roleDao.saveRoleMenu(role);
    }
}
