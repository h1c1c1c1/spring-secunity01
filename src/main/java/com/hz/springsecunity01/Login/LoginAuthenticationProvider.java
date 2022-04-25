package com.hz.springsecunity01.Login;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class LoginAuthenticationProvider implements AuthenticationProvider {
    @Override
    //重新AuthenticationProvider里的方法
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //拿到用户名跟密码
        String userName =(String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        System.out.println("userName========"+userName);
        System.out.println("password========"+password);
            //设置的权限必须以 ROLE开头
                Collection<GrantedAuthority> authorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");


        return new UsernamePasswordAuthenticationToken(  );
    }
    /*** 如果该AuthenticationProvider支持传入的Authentication对象，则返回true * @param aClass * @return */
    @Override
    public boolean supports(Class<?> aClass) {

        return aClass.equals( UsernamePasswordAuthenticationToken.class );
    }
}
