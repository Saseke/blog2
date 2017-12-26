package com.spring.blog2.service.Impl;

import com.spring.blog2.service.AuthorService;
import org.springframework.stereotype.Service;

/**
 * 控制主体
 */
@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    public boolean login(String username, String password) {
        return true;
    }

    @Override
    public boolean logout() {
        return false;
    }
}
