package com.spring.blog2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 配置SpringSecurity
 * 处理密码的加密和解密：    PaaawordEncoder接口
 */
@Configuration
public class WebConfigration extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .loginPage("/login.ftl")
//                .loginProcessingUrl("/author/form")
//                .defaultSuccessUrl("/addArticle")
//                .and()
//                .authorizeRequests()
//////                访问该页面不需要身份验证,同时也是配置静态资源允许访问的地方
//                .antMatchers("/article/**").permitAll()
//                .antMatchers("/").permitAll()
//                .antMatchers("/login.ftl").permitAll()
//                .antMatchers("/**/*.js").permitAll()
//                .antMatchers("/**/*.css").permitAll()
//                .antMatchers("/**/*.jpg").permitAll()
//                .antMatchers("/upload/**").permitAll()
//                .antMatchers("/home/smy/upload/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/article/see/**").permitAll()
                .antMatchers("article/findarticles/**").permitAll()
                .antMatchers("/**/*.js").permitAll()
                .antMatchers("/**/*.css").permitAll()
                .antMatchers("/**/*.jpg").permitAll()
                .antMatchers("/upload/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .anyRequest().authenticated()    //其他资源都需要认证,登录后访问
                .and()
                .formLogin()
                .loginPage("/login.ftl")
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .csrf().disable();


    }
}
