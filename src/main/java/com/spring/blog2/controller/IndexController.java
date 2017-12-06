package com.spring.blog2.controller;

import com.spring.blog2.obj.Article;
import com.spring.blog2.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);
    private final ArticleService articleService;

    @Autowired
    public IndexController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        List<Article> list = articleService.findAll();
        logger.info("--------主页---------------");
        modelAndView.setViewName("index");
        return modelAndView.addObject("list", list);
    }
}
