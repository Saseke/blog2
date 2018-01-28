package com.spring.blog2.service.Impl;

import com.github.pagehelper.PageRowBounds;
import com.spring.blog2.obj.Category;
import com.spring.blog2.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Resource
    private CategoryService categoryService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImplTest.class);

    @Test
    public void listCateGory() {
        List<Category> list = categoryService.list();
        System.out.println(list.size());
    }

    @Test
    public void list() {
        List<Category> list = categoryService.list();
        LOGGER.info("-----------查出所有的栏目------" + list.size() + "-------------------");
    }

    @Test
    public void list1() {
        List<Category> list = categoryService.list(new PageRowBounds(1, 3));
        LOGGER.info("--------------分页显示所有的栏目信息-----------" + list.size() + "----------------------------");
    }

    @Test
    public void findById() {
        Category category = categoryService.findById(2L);
        LOGGER.info("------------------id为1的栏目信息-------------" + category.getId() + category.getName() + category.getCreateDate() + "-------------------------");
    }

    @Test
    public void findByName() {
//        Category category = categoryService.findByName("demo3");
//        LOGGER.info("-------------------名字为demo3的栏目信息-------------" + category.getId() + category.getCreateDate() + "----------------------------------");
    }

    @Test
    public void add() {
        Category category = new Category("test", new Date());
        int count = categoryService.add(category);
        LOGGER.info("-------------插入成功信息：影响的数据信息条数为-------" + count + "-----------------------------");
    }

    @Test
    public void update() {
        Category category = new Category(2L, "testdemo1", new Date());
        categoryService.update(category);
    }

    @Test
    public void delete() {
        int count = categoryService.delete(1);
        LOGGER.info("------------------删除的栏目----------" + count + "-----------------------");
    }
}
