package com.spring.blog2.service;


import com.spring.blog2.obj.Category;

import java.util.List;

/**
 * 博客文章类型分类
 */
public interface CategoryService {
    /**
     * 列出所有的分类
     *
     * @return 找出的所有文章类型
     */
    List<Category> list();

    /**
     * 通过类型的id查找 对应的分类
     *
     * @param id 分类的id
     * @return 查到的分类
     */
    Category findById(long id);

    /**
     * 通过分类的名称查找分类
     *
     * @param name 分类的名称
     * @return 查询到的分类
     */
    Category findByName(String name);

    /**
     * 添加一个分类
     *
     * @param category 要添加的分类
     * @return 数据库影响的条数
     */
    int add(Category category);

    /**
     * 更新分类
     *
     * @param category 新的分类
     * @return 影响的数据条数
     */
    int update(Category category);

    /**
     * 根据分类的id删除分类
     *
     * @param id 分类的idd
     * @return 影响的数据条数
     */
    int delete(long id);
}
