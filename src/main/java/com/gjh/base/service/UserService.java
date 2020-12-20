package com.gjh.base.service;

import com.gjh.base.auth.model.SysUser;

/**
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 22:46
 */
public interface UserService {
    SysUser getUserByName(String username);
}
