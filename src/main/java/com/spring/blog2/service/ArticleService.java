package com.spring.blog2.service;

import com.spring.blog2.obj.Article;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 对文章进行增删改除操作的接口类
 *
 * @author SongMengYuan
 * @version 1.0
 */
public interface ArticleService {
    /**
     * 统计博客所有的文章
     *
     * @return 所有文章的数目
     */
    long counttotal();

    /**
     * 统计一段时间内的文章数目
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 这段时间内的所有文章的数目
     */
    long countByDate(Date start, Date end);

    /**
     * 统计特定时间之后所有的文章数目
     *
     * @param date 指定的时间
     * @return 指定时间后的文章数目
     */
    long countByDateAfter(Date date);

    /**
     * 统计在指定日期之前的文章
     *
     * @param date 指定的日期
     * @return 查出文章的数目
     */
    long countByDateBefore(Date date);

    /**
     * 通过文章的id查找文章
     *
     * @param id 文章的id
     * @return 查询到的文章
     */
    Article findById(long id);

    /**
     * 查询出所有的文章
     *
     * @return 返回查询出来的所有的文章
     */
    List<Article> findAll();

    /**
     * 查询所有的文章，带有分页效果
     *
     * @param rowBounds 分页效果
     * @return 返回查询具有分页效果的文章
     */
    List<Article> findAll(RowBounds rowBounds);

    /**
     * 查询出某一段id区间内的文章
     *
     * @param list 要查询的id区间
     * @return 查询到的文章
     */
    List<Article> findByIdList(List<Long> list);

    /**
     * 文章按照阅读量进行排序
     *
     * @param blob 是否加载大资源文件
     * @return 返回查询得到的文章
     */
    List<Article> findByOrderByBrowse(boolean blob);

    /**
     * 查询特定浏览次数 区间内的文章
     *
     * @param start     浏览量的最小值
     * @param end       浏览量的最大值
     * @param blob      是否加载大的图片
     * @param rowBounds 分页功能
     * @return 要查询的文章
     */
    List<Article> findByBrowse(long start, long end, boolean blob, RowBounds rowBounds);

    /**
     * 查询指定浏览量区间内的文章
     *
     * @param start 浏览量的最小值
     * @param end   浏览量的最大值
     * @param blob  是否加载大的资源信息
     * @return 查询到的文章
     */
    List<Article> findByBrowse(long start, long end, boolean blob);

    /**
     * 查询超过一定浏览量的文章
     *
     * @param time 浏览次数
     * @param blob 是否加载大的资源
     * @return 查询到的文章
     */
    List<Article> findByBrowseGreater(long time, boolean blob);

    /**
     * 插入文章
     *
     * @param article 要插入的文章
     * @return 影响的数据库条数
     */
    @Transactional
    int insertSelective(Article article);

    /**
     * 根据文章id删除文章
     *
     * @param id 文章id
     * @return 影响的条数
     */
    @Transactional
    int deleteById(long id);

    /**
     * 根据id删除多条文章
     *
     * @param idList 要删除id的集合
     * @return 影响数据的条数
     */
    @Transactional
    int deleteByIdList(List<Long> idList);

    /**
     * 更新文章，并且更新大的资源文件
     *
     * @param article 要更新的文章
     * @return 影响数据的条数
     */
    @Transactional
    int updateWithBlobById(Article article);

    /**
     * 更新文章，不更新大的资源文件
     *
     * @param article 要更新的文章
     * @return 影响的文章条数
     */
    @Transactional
    int updateWithoutBlobById(Article article);
}
