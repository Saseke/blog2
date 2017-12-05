package com.spring.blog2.service.Impl;

import com.spring.blog2.dao.ArticleMapper;
import com.spring.blog2.entity.Article;
import com.spring.blog2.service.ArticleService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public long counttotal() {
        return 0;
    }

    @Override
    public long countByDate(Date start, Date end) {
        return 0;
    }

    @Override
    public long countByDateAfter(Date date) {
        return 0;
    }

    @Override
    public long countByDateBefore(Date date) {
        return 0;
    }

    @Override
    public Article findById(long id) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public List<Article> findAll(RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<Article> findByIdList(List<Long> list) {
        return null;
    }

    @Override
    public List<Article> findByOrderByBrowse(boolean blob) {
        return null;
    }

    @Override
    public List<Article> findByBrowse(long start, long end, boolean blob, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<Article> findByBrowse(long start, long end, boolean blob) {
        return null;
    }

    @Override
    public List<Article> findByBrowseGreater(long time, boolean blob) {
        return null;
    }

    @Override
    public List<Article> findByClassify(String classifyName) {
        return null;
    }

    @Override
    public int insertSelective(Article article) {
        return 0;
    }

    @Override
    public int deleteById(long id) {
        return 0;
    }

    @Override
    public int deleteByIdList(List<Long> idList) {
        return 0;
    }

    @Override
    public int updateWithBlobById(Article article) {
        return 0;
    }

    @Override
    public int updateWithoutBlobById(Article article) {
        return 0;
    }
}
