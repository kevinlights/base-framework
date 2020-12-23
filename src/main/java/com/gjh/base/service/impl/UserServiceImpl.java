package com.gjh.base.service.impl;

import com.gjh.base.auth.dao.UserDao;
import com.gjh.base.auth.model.SysUser;
import com.gjh.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 22:46
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Cacheable(cacheNames = "authority", key = "#username")
    @Override
    public SysUser getUserByName(String username) {
        return userDao.selectByName(username);
    }
}
