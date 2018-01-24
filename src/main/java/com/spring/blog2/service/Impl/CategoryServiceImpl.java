package com.spring.blog2.service.Impl;

import com.spring.blog2.dao.ArticleMapper;
import com.spring.blog2.dao.CategoryMapper;
import com.spring.blog2.obj.Article;
import com.spring.blog2.obj.ArticleExample;
import com.spring.blog2.obj.Category;
import com.spring.blog2.obj.CategoryExample;
import com.spring.blog2.service.ArticleService;
import com.spring.blog2.service.CategoryService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Category> list() {
        CategoryExample example = new CategoryExample();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<Category> list(RowBounds rowBounds) {
        CategoryExample categoryExample = new CategoryExample();
        return categoryMapper.selectByExample(categoryExample, rowBounds);
    }

    @Override
    public Category findById(long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public Category findByName(String name) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.or().andNameEqualTo(name);
        return categoryMapper.selectByExample(categoryExample).get(0);
    }

    @Override
    public int add(Category category) {
        CategoryExample categoryExample = new CategoryExample();
        return categoryMapper.insert(category);
    }

    @Override
    public int update(Category category) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.or().andIdEqualTo(category.getId());
        return categoryMapper.updateByExample(category, categoryExample);
    }

    @Override
    public int delete(long id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Article> listCategoryofArticle(Long id, boolean withBLOB) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.or().andCategoryIdEqualTo(id);
        if (withBLOB) return articleMapper.selectByExampleWithBLOBs(articleExample);
        else return articleMapper.selectByExample(articleExample);
    }

    @Override
    public List<Article> listCategoryofArticle(Long id, boolean withBLOB, RowBounds rowBounds) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.or().andCategoryIdEqualTo(id);
        if (withBLOB) return articleMapper.selectByExampleWithBLOBs(articleExample, rowBounds);
        else return articleMapper.selectByExample(articleExample, rowBounds);
    }
}
