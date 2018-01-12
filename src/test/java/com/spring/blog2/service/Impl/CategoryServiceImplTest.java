package com.spring.blog2.service.Impl;

import com.spring.blog2.obj.Category;
import com.spring.blog2.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void listCateGory() {
        List<Category> list = categoryService.list();
        System.out.println(list.size());
    }
}
