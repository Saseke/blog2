package com.spring.blog2.service;

import com.spring.blog2.Blog2Application;
import com.spring.blog2.obj.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Blog2Application.class)
public class ArticleServiceTest {
    private final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceTest.class);
    @Autowired
    private ArticleService articleService;

    @Test
    public void findAll() throws Exception {
        List<Article> list = articleService.findAll();
        LOGGER.info("------list all article----" + list.get(0).getContent() + "-------------");
    }
}