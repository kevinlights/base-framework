package com.gjh.base.auth.model;

import java.util.List;

/**
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 22:50
 */
public class SysRole {

    private long id;
    private RoleName name;
    private String alias;

    private List<SysPermission> permissions;

    public SysRole(RoleName name, String alias) {
        this.name = name;
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
}
