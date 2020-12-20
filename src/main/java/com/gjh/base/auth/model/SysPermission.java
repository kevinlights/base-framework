package com.gjh.base.auth.model;

/**
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 22:51
 */
public class SysPermission {
    private long id;
    private String name;
    private String url;
    private String code;

    public SysPermission() {
    }

    public SysPermission(String name, String code, String url) {
        this.name = name;
        this.url = url;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
