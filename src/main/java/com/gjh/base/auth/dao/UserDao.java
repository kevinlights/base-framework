package com.gjh.base.auth.dao;

import com.gjh.base.auth.model.RoleName;
import com.gjh.base.auth.model.SysPermission;
import com.gjh.base.auth.model.SysRole;
import com.gjh.base.auth.model.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 22:54
 */
@Repository
public class UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    private SysRole admin = new SysRole(RoleName.ROLE_ADMIN, "Administor");

    private SysRole developer = new SysRole(RoleName.ROLE_DEVELOPER, "Developer");

    private List<SysUser> users = new ArrayList<>();

    {
        SysPermission p1 = new SysPermission("User Index", "UserIndex", "/user/index");
        SysPermission p2 = new SysPermission("Book List", "BookList", "/book/list");
        SysPermission p3 = new SysPermission("Book Add", "BookAdd", "/book/add");
        SysPermission p4 = new SysPermission("Book Detail", "BookDetail", "/book/detail");

        admin.setPermissions(Arrays.asList(p1, p2, p3, p4));
        developer.setPermissions(Arrays.asList(p1, p2));
    }

    {
        // mock users, all password is '1'

        users.add(new SysUser("zhangsan", "1", Arrays.asList(admin, developer)));
        users.add(new SysUser("lisi", "1", Arrays.asList(developer)));
    }

    public SysUser selectByName(String username) {
        LOGGER.info("select user by username: {}", username);
        LOGGER.info("user number is {}", users.size());
        for (SysUser sysUser : users) {
            if (sysUser.getName().equals(username)) {
                LOGGER.info("find user and return it");
                return sysUser;
            }
        }
        LOGGER.info("not found, return null");
        return null;
    }
}
