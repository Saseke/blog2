package com.spring.blog2.controller;

import com.github.pagehelper.PageRowBounds;
import com.spring.blog2.obj.Article;
import com.spring.blog2.obj.Category;
import com.spring.blog2.service.ArticleService;
import com.spring.blog2.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);
    private final ArticleService articleService;

    @Autowired
    public IndexController(ArticleService articleService, CategoryService categoryService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
    }

    private final CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model) {
        List<Article> list = articleService.selectByCreateDate();
        List<Category> categorylist = categoryService.list();
        logger.info("--------主页---------------");
        logger.info("-----article的内容------" + list.toString() + "-------------");
        model.addAttribute("list", list);
        model.addAttribute("categorylist", categorylist);
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
