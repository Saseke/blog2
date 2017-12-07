package com.spring.blog2.service.Impl;

import com.spring.blog2.dao.ArticleMapper;
import com.spring.blog2.obj.Article;
import com.spring.blog2.obj.ArticleExample;
import com.spring.blog2.service.ArticleService;
import com.spring.blog2.util.TimeUtil;
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
    public long countByAuthor(String author) {
        return 0;
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
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Article> findAll() {
        ArticleExample articleExample = new ArticleExample();
        List<Article> list = articleMapper.selectByExample(articleExample);
        for (Article article : list) {
            String content = articleMapper.selectByPrimaryKey(article.getId()).getContent();
            if (content.length() > 300) {
                content =  content.substring(0, content.length() / 3);
            }
            article.setContent(content);
            article.setShortTime(TimeUtil.getShortTime(article.getCreatetime()));
        }
        return list;
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
    public List<Article> findByTitle(String title, boolean withBLOB, boolean fuzzy) {
        return null;
    }

    @Override
    public List<Article> findByOrderByBrowse(boolean withBLOB, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<Article> findByOrderByBrowse(boolean withBLOB) {
        return null;
    }

    @Override
    public List<Article> findByCreateDate(Date start, Date end, boolean withBLOB, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<Article> findByCreateDate(Date start, Date end, boolean withBLOB) {
        return null;
    }

    @Override
    public List<Article> findByBrowseGreater(long time, boolean withBLOB) {
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
    public int deleteByTitle(String title) {
        return 0;
    }

    @Override
    public int deleteBetweenDate(Date start, Date end) {
        return 0;
    }

    @Override
    public int deleteAfterDate(Date date) {
        return 0;
    }

    @Override
    public int deleteBeforeDate(Date date) {
        return 0;
    }

    @Override
    public int updateAllWithoutBLOBById(Article article) {
        return 0;
    }

    @Override
    public int updateAllById(Article article) {
        return 0;
    }

    @Override
    public int updateSelectiveById(Article article) {
        return 0;
    }
}
