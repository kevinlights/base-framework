package com.gjh.base.auth.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SysUserTest {

    private SysUser sysUser;

    @Before
    public void setUp() throws Exception {
        sysUser = new SysUser();
        sysUser.setId(1l);
        sysUser.setName("a");
        sysUser.setPassword("123");
    }

    @Test
    public void getId() {
        assertEquals(1l, sysUser.getId());
    }

    @Test
    public void setId() {
        sysUser.setId(2l);
        assertEquals(2l, sysUser.getId());
    }

    @Test
    public void getName() {
        assertEquals("a", sysUser.getName());
    }

    @Test
    public void setName() {
    }

    @Test
    public void getPassword() {
    }

    @Test
    public void setPassword() {
    }

    @Test
    public void getRoles() {
    }

    @Test
    public void setRoles() {
    }
}