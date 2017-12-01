package com.spring.blog2.service;

/**
 * 用户登录接口
 *
 * @author SongMengYuan
 * @version 1.0
 */
public interface AuthorService {
    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录是否成功
     */
    boolean login(String username, String password);

    /**
     * 用户注销
     *
     * @return 注销是否成功
     */
    boolean logout();
}
