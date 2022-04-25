package com.hz.springsecunity01.Config;

import com.hz.springsecunity01.Login.LoginAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.rmi.runtime.Log;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //实列化过滤器
    @Autowired
    private LoginAuthenticationProvider provider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //登录调用provider
        auth.authenticationProvider( provider );
//        auth.inMemoryAuthentication().passwordEncoder( passwordEncoder() ).withUser("hcc").
//                password( passwordEncoder().encode(  "123") ).roles( "USER" );
    }

    protected void configure(HttpSecurity http)throws Exception{
        //关闭  csrf防护
        http.
                csrf().
                disable().
                headers().
                frameOptions().
                disable().
                and();
        //登录处理
        http.formLogin().//表单方式，或httpBasic
                loginPage( "/login.html" ).//自定义登录页面
                loginProcessingUrl( "/form" ).//表单提交
                defaultSuccessUrl( "/admin/hello" ).//成功登陆后跳转页面
                permitAll();//放行以上路径

    }


//    @Bean
//     PasswordEncoder passwordEncoder() {
//
//        return new BCryptPasswordEncoder(  );
//    }
}

