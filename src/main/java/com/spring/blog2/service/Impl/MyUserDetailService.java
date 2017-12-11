package com.spring.blog2.service.Impl;

import com.spring.blog2.dao.AuthorMapper;
import com.spring.blog2.obj.Author;
import com.spring.blog2.obj.AuthorExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserDetailsService    处理用户信息获取逻辑
 * UserDetails      处理用户校验逻辑
 */
@Service
public class MyUserDetailService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final AuthorMapper authorMapper;
    private Logger LOGGER = LoggerFactory.getLogger(MyUserDetailService.class);

    @Autowired
    public MyUserDetailService(AuthorMapper authorMapper, PasswordEncoder passwordEncoder) {
        this.authorMapper = authorMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        根据用户名查询用户
        AuthorExample example = new AuthorExample();
        example.or().andUsernameEqualTo(s);
        LOGGER.info("登录姓名:------------" + s);
        List<Author> list = authorMapper.selectByExample(example);
//        处理用户逻辑
        return new User(s, passwordEncoder.encode(list.get(0).getPassword()), true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
