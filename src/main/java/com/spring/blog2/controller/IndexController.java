package com.spring.blog2.controller;

import com.github.pagehelper.PageRowBounds;
import com.spring.blog2.obj.Article;
import com.spring.blog2.service.ArticleService;
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
    public IndexController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) Integer page, Model model) {
        int currentNum = 0;
        int limit = 3;
        PageRowBounds pageRowBounds;
        if (page != null) {
            currentNum = page;
            pageRowBounds = new PageRowBounds(page, limit);
        } else {
            currentNum = 1;
            pageRowBounds = new PageRowBounds(1, limit);
        }
        List<Article> list = articleService.selectByCreateDate(pageRowBounds);
        logger.info("--------主页---------------");
        logger.info("-----article的内容------" + list.toString() + "-------------");
        model.addAttribute("list", list);
        model.addAttribute("page", currentNum);
//        model.addAttribute("total", pageRowBounds.getTotal());
        model.addAttribute("pagetotal");
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/consule")
    public ModelAndView consule(ModelAndView modelAndView) {
        modelAndView.setViewName("controlindex");
        return modelAndView;
    }
}
