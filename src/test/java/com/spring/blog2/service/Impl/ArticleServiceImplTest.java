package com.spring.blog2.service.Impl;

import com.github.pagehelper.PageRowBounds;
import com.spring.blog2.obj.Article;
import com.spring.blog2.service.ArticleService;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImplTest.class);
    @Resource
    private ArticleService articleService;

    @Test
    public void selectByCreateDate() throws Exception {
        List<Article> list = articleService.selectByCreateDate(new PageRowBounds(0, 2));
        for (Article article : list) {
            System.out.println(article.getId());
        }
    }

    @Test
    public void insertArticle() {
        Article article = new Article("demo", "csdcsd", "dwdcsdcsd");
        articleService.insert(article);
    }

    @Test
    public void selectByCategoryId() {
        List<Article> list = articleService.listCategoryArticle(1L);
        System.out.println(list.size());
    }

    @Test
    public void selectByCreateDat() {
        PageRowBounds rowBounds = new PageRowBounds(1, 3);
        List<Article> list = this.articleService.selectByCreateDate(rowBounds);
        System.out.println(rowBounds.getTotal());
        System.out.println(list.size());
        List<Article> list1 = this.articleService.selectByCreateDate(new RowBounds(2, 3));
        for (Article article : list1) {
            System.out.println(article.getTitle());
        }
    }

    @Test
    public void countByAuthor() {
        long count = articleService.countByAuthor("yoke");
        logger.info("---------------------yoke写的文章数量--------------" + count + "------------------");
    }

    @Test
    public void counttotal() {
        long count = articleService.counttotal();
        logger.info("--------------文章总数-------" + count + "-------------------------");
    }

    @Test
    public void countByDate() {
    }

    @Test
    public void countByDateAfter() {
    }

    @Test
    public void countByDateBefore() {
    }

    @Test
    public void findById() {
        Article article = articleService.findById(5);
        logger.info("---------------查询id为1的文章 ---------" + article.getId() + "------------------");
    }

    @Test
    public void findAll() {
        List<Article> list = articleService.findAll();
        logger.info("---------------文章的总数--------------" + list.size() + "-------------------");
    }

    @Test
    public void findAll1() {
        List<Article> list = articleService.findAll(new PageRowBounds(1, 10));
        logger.info("--------------分页后文章第一页的数量-----------" + list.size() + "--------------------");

    }

    @Test
    public void findByIdList() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(3L);
        List<Article> list1 = articleService.findByIdList(list);
        logger.info("----------------findByIdList---------------" + list1.size() + "----------------------");
    }

    @Test
    public void findByTitle() {
        List<Article> list = articleService.findByTitle("demo", false, false);
        logger.info("------------------------findByTitle---------------" + list.size() + "--------------------");
    }

    @Test
    public void findByOrderByBrowse() {
    }

    @Test
    public void findByOrderByBrowse1() {
    }

    @Test
    public void findByCreateDate() {
    }

    @Test
    public void findByCreateDate1() {
    }

    @Test
    public void findByBrowseGreater() {
    }

    @Test
    public void selectByCreateDate1() {
    }

    @Test
    public void selectByCreateDate2() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void deleteByIdList() {
    }

    @Test
    public void deleteByTitle() {
    }

    @Test
    public void deleteBetweenDate() {
    }

    @Test
    public void deleteAfterDate() {
    }

    @Test
    public void deleteBeforeDate() {
    }

    @Test
    public void updateAllWithoutBLOBById() {
    }

    @Test
    public void updateAllById() {
    }

    @Test
    public void updateSelectiveById() {
    }

    @Test
    public void listCategoryArticle() {
    }
}