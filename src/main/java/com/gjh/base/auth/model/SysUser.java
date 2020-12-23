package com.gjh.base.auth.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 22:47
 */
public class SysUser {

    private long id;
    private String name;
    private String password;

    private List<SysRole> roles = new ArrayList<>();

    public SysUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public SysUser(String name, String password, List<SysRole> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public SysUser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
