package com.spring.blog2.service.Impl;

import com.github.pagehelper.PageRowBounds;
import com.spring.blog2.obj.Article;
import com.spring.blog2.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {
    @Autowired
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
}