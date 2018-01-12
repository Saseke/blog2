package com.spring.blog2.service.Impl;

import com.spring.blog2.dao.ArticleMapper;
import com.spring.blog2.dao.CategoryMapper;
import com.spring.blog2.obj.Article;
import com.spring.blog2.obj.Category;
import com.spring.blog2.obj.CategoryExample;
import com.spring.blog2.service.ArticleService;
import com.spring.blog2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ArticleService articleService;

    @Override
    public List<Category> list() {
        CategoryExample example = new CategoryExample();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public Category findById(long id) {
        return null;
    }

    @Override
    public Category findByName(String name) {
        return null;
    }

    @Override
    public int add(Category category) {
        return 0;
    }

    @Override
    public int update(Category category) {
        return 0;
    }

    @Override
    public int delete(long id) {
        return 0;
    }
}
