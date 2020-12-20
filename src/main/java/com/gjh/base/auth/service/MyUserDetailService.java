package com.gjh.base.auth.service;

import com.gjh.base.auth.model.SysPermission;
import com.gjh.base.auth.model.SysRole;
import com.gjh.base.auth.model.SysUser;
import com.gjh.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guangjh
 * @version 1.0
 * @date 2020/12/15 22:44
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (SysRole role : user.getRoles()) {
            for (SysPermission permission : role.getPermissions()) {
                authorities.add(new SimpleGrantedAuthority(permission.getCode()));
            }
        }
        return new User(user.getName(), user.getPassword(), authorities);
    }
}
