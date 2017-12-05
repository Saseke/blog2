package com.spring.blog2.DAO;

import com.spring.blog2.Blog2Application;
import com.spring.blog2.obj.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Blog2Application.class)
public class ArticleMapperTest {
    @Autowired
    ArticleMapper articleMapper;
    @Test
    public void selectByPrimaryKey() throws Exception {
        Article article =  articleMapper.selectByPrimaryKey(1L);
        System.out.println(article.toString());
    }

}