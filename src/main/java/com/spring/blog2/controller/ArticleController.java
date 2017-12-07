package com.spring.blog2.controller;

import com.spring.blog2.obj.Article;
import com.spring.blog2.service.ArticleService;
import com.spring.blog2.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;
    private final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/see/{id}")
    public ModelAndView singleArticle(@PathVariable("id") String i, ModelAndView modelAndView) {
        long id = Long.parseLong(i);
        Article article = articleService.findById(id);
        article.setShortTime(TimeUtil.getShortTime(article.getCreatetime()));
        LOGGER.info("------see article--------" + article.toString() + "-----------------");
        modelAndView.addObject("article", article);
        modelAndView.setViewName("singlearticle");
        return modelAndView;
    }
}
