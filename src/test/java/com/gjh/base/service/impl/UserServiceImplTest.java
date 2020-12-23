package com.gjh.base.service.impl;

import com.gjh.base.auth.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void getUserByName() {
        SysUser userByName = userService.getUserByName("123");
        assertNull(userByName);
    }
}