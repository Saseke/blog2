package com.spring.blog2.controller.api;

import com.spring.blog2.controller.ArticleController;
import com.spring.blog2.obj.AjaxData;
import com.spring.blog2.obj.Article;
import com.spring.blog2.obj.Category;
import com.spring.blog2.obj.Message;
import com.spring.blog2.service.ArticleService;
import com.spring.blog2.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/article/api/")
public class ArticleAPI {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
    @Resource
    private ArticleService articleService;

    @Resource
    private CategoryService categoryService;

    @ResponseBody
    @GetMapping("/list")
    public AjaxData findAll() {
        ArrayList<Article> list = (ArrayList<Article>) articleService.findAll();
        return new AjaxData(0, "", 10, list);
    }

    @GetMapping("/find")
    public Article findOne(@RequestParam("id") Long id) {
        if (id != null)
            return articleService.findById(id);
        return null;
    }

    @GetMapping("/addArticle")
    public ModelAndView toaddArticle(ModelAndView modelAndView) {
        List<Category> categories = categoryService.list();
        modelAndView.addObject("categories", categories);
        modelAndView.setViewName("addArticle");
        return modelAndView;
    }
}
