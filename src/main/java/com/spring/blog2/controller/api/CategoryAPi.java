package com.spring.blog2.controller.api;

import com.spring.blog2.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/category/api")
public class CategoryAPi {
    @Resource
    private CategoryService categoryService;

    /*@GetMapping("/list")
    public AjaxData list(@RequestParam(required = false) Integer page) {
        int limit = 30;
        if (page == null) {
            page = 1;
        } else {

        }
    }*/
}
