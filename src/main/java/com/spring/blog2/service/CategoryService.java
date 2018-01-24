package com.spring.blog2.service;


import com.spring.blog2.obj.Article;
import com.spring.blog2.obj.Category;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 博客文章类型分类
 */
public interface CategoryService {
    /**
     * 列出所有的栏目
     *
     * @return 查询得到的所有栏目
     */
    List<Category> list();

    /**
     * 列出所有的分类,分页类型
     *
     * @return 找出的所有文章类型
     */
    List<Category> list(RowBounds rowBounds);

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

    /**
     * 列出该栏目下的所有文章
     *
     * @param id
     * @return
     */
    List<Article> listCategoryofArticle(Long id, boolean withBLOB);

    /**
     * 列出该栏目下的所有文章带分页效果
     *
     * @param id        栏目的id
     * @param withBLOB  是否查询出文章的大文件
     * @param rowBounds 分页
     * @return
     */
    List<Article> listCategoryofArticle(Long id, boolean withBLOB, RowBounds rowBounds);
}
