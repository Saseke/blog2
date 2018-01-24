package com.spring.blog2.service.Impl;

import com.spring.blog2.dao.ArticleMapper;
import com.spring.blog2.obj.Article;
import com.spring.blog2.obj.ArticleExample;
import com.spring.blog2.service.ArticleService;
import com.spring.blog2.util.TimeUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {


    @Resource
    private ArticleMapper articleMapper;

    @Override
    public long countByAuthor(String author) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.or().andAuthorNameEqualTo(author);
        List<Article> list = articleMapper.selectByExample(articleExample);
        return list.size();
    }

    @Override
    public long counttotal() {
        ArticleExample articleExample = new ArticleExample();
        List<Article> list = articleMapper.selectByExample(articleExample);
        return list.size();
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
        return articleMapper.selectByExample(articleExample);
    }

    @Override
    public List<Article> findAll(RowBounds rowBounds) {
        ArticleExample articleExample = new ArticleExample();
        return articleMapper.selectByExample(articleExample, rowBounds);
    }

    @Override
    public List<Article> findByIdList(List<Long> list) {
        List<Article> articles = new ArrayList<>();
        for (Long id : list) {
            articles.add(articleMapper.selectByPrimaryKey(id));
        }
        return articles;
    }

    @Override
    public List<Article> findByTitle(String title, boolean withBLOB, boolean fuzzy) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.or().andTitleEqualTo(title);
        if (withBLOB) return articleMapper.selectByExampleWithBLOBs(articleExample);
        else return articleMapper.selectByExample(articleExample);
    }

    @Override
    public List<Article> findByOrderByBrowse(boolean withBLOB, RowBounds rowBounds) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.setOrderByClause("browseTime DESC");
        if (withBLOB) return articleMapper.selectByExampleWithBLOBs(articleExample, rowBounds);
        else return articleMapper.selectByExample(articleExample, rowBounds);
    }

    @Override
    public List<Article> findByOrderByBrowse(boolean withBLOB) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.setOrderByClause("browseTime DESC");
        if (withBLOB) return articleMapper.selectByExampleWithBLOBs(articleExample);
        else return articleMapper.selectByExample(articleExample);
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
    public List<Article> findByBrowseGreater(Integer time, boolean withBLOB) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.or().andBrowsetimeGreaterThanOrEqualTo(time);
        if (withBLOB) return articleMapper.selectByExampleWithBLOBs(articleExample);
        else return articleMapper.selectByExample(articleExample);
    }

    @Override
    public List<Article> selectByCreateDate(RowBounds rowBounds) {
        ArticleExample example = new ArticleExample();
        example.setOrderByClause(" createtime  DESC");
        List<Article> list = articleMapper.selectByExampleWithBLOBs(example, rowBounds);
        return common(list);
    }

    @Override
    public List<Article> selectByCreateDate() {
        List<Article> list = articleMapper.selectByCreateDate();
        return common(list);
    }

    @Async
    @Override
    public int insertSelective(Article article) {
        return 0;
    }

    @Async
    @Override
    public int insert(Article article) {
        article.setCreatetime(new Date());
        article.setAuthorId(1L);
        return articleMapper.insert(article);
    }

    @Async
    @Override
    public int deleteById(long id) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.or().andIdEqualTo(id);
        return articleMapper.deleteByExample(articleExample);
    }

    @Async
    @Override
    public int deleteByIdList(List<Long> idList) {
        int count = 0;
        for (Long id : idList) {
            ArticleExample articleExample = new ArticleExample();
            articleExample.or().andIdEqualTo(id);
            count = articleMapper.deleteByExample(articleExample);
        }
        return count;
    }

    @Async
    @Override
    public int deleteByTitle(String title) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.or().andTitleEqualTo(title);
        return articleMapper.deleteByExample(articleExample);
    }

    @Async
    @Override
    public int deleteBetweenDate(Date start, Date end) {
        return 0;
    }

    @Async
    @Override
    public int deleteAfterDate(Date date) {
        return 0;
    }

    @Async
    @Override
    public int deleteBeforeDate(Date date) {
        return 0;
    }

    @Override
    public int updateAllWithoutBLOBById(Article article) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.or().andIdEqualTo(article.getId());
        articleMapper.selectByExample(articleExample);
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

    @Override
    public List<Article> listCategoryArticle(Long id) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.or().andCategoryIdEqualTo(id);
        List<Article> list = articleMapper.selectByExampleWithBLOBs(articleExample);
        return common(list);
    }

    /**
     * 统一对文章进行截取的方法
     *
     * @param list 文章的计划外
     * @return 截取文章内容成功后返回的文章
     */
    private List<Article> common(List<Article> list) {
        for (Article article : list) {
            String content = article.getContent();
            if (content.length() > 300) {
                content = content.substring(0, content.length() / 3);
            }
            article.setContent(content);
            article.setShortTime(TimeUtil.getShortTime(article.getCreatetime()));
        }
        return list;
    }
}
