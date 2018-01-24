package com.spring.blog2.controller;

import com.github.pagehelper.PageRowBounds;
import com.spring.blog2.obj.Article;
import com.spring.blog2.obj.Category;
import com.spring.blog2.service.ArticleService;
import com.spring.blog2.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Resource
    private ArticleService articleService;
    @Resource
    private CategoryService categoryService;

    @GetMapping("/")
    public String index(@RequestParam(required = false) Integer page, Model model) {
        PageRowBounds pageRowBounds;
        int limit = 10;   //每页显示的条数
        if (page != null) {
            pageRowBounds = new PageRowBounds(page, limit);
        } else {
            page = 1;
            pageRowBounds = new PageRowBounds(page, limit);
        }
        List<Article> list = articleService.selectByCreateDate(pageRowBounds);
        List<Category> categoryList = categoryService.list();
        model.addAttribute("categorylist", categoryList);
        model.addAttribute("list", list);

        model.addAttribute("total", Math.ceil(pageRowBounds.getTotal() / limit) + 1);
        model.addAttribute("current", page);
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
