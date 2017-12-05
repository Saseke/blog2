package com.spring.blog2.service;

import com.spring.blog2.obj.Article;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 该类对文章进行饭管理
 *
 * @author Smy
 * @version 1.0
 */
public interface ArticleService {
    /**
     * 统计作者所有的文章数目
     *
     * @param author 作者名称
     * @return 查询得到的条数
     */
    long countByAuthor(String author);

    /**
     * 统计某一时间段内文章的数目
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 查询到的条数
     */
    long countByDate(Date start, Date end);

    /**
     * 统计某个时间之后的文章数目
     *
     * @param date 指定的日期
     * @return 查询的到的文章数目
     */
    long countByDateAfter(Date date);

    /**
     * 统计指定日期之前的所有文章
     *
     * @param date 指定的日期
     * @return 查询得到的条数
     */
    long countByDateBefore(Date date);

    /**
     * 根据文章id查询文章
     *
     * @param id 文章的id
     * @return 查询得到的文章
     */
    Article findById(long id);

    /**
     * 列出所有的文章
     *
     * @return 返回所有的文章对象
     */
    List<Article> findAll();

    /**
     * 带有分页功能的查询所有文章
     *
     * @param rowBounds 分页的参数
     * @return 列出所有的文章
     */
    List<Article> findAll(RowBounds rowBounds);

    /**
     * 根据一群id查询一群文章
     *
     * @param list 文章id的集合
     * @return 一群文章
     */
    List<Article> findByIdList(List<Long> list);

    /**
     * 通过文章标题查询文章
     *
     * @param title    文章的标题
     * @param withBLOB 是否显示文章内容
     * @param fuzzy    懒加载
     * @return 查询得到的文章集合
     */
    List<Article> findByTitle(String title, boolean withBLOB, boolean fuzzy);

    /**
     * 按照访问量排序
     *
     * @param withBLOB  是否加载大文件
     * @param rowBounds 分页参数
     * @return 查询得到的所有文章
     */
    List<Article> findByOrderByBrowse(boolean withBLOB, RowBounds rowBounds);

    List<Article> findByOrderByBrowse(boolean withBLOB);

    /**
     * 查询指定时间段内的文章
     *
     * @param start     开始时间
     * @param end       结束时间
     * @param withBLOB  是否加载大文件
     * @param rowBounds 分页参数
     * @return 列出查询得到的文章
     */
    List<Article> findByCreateDate(Date start, Date end, boolean withBLOB, RowBounds rowBounds);

    List<Article> findByCreateDate(Date start, Date end, boolean withBLOB);

    /**
     * 查询超过一定访问量的文章
     *
     * @param time     访问的次数限定
     * @param withBLOB 是否加载大文件
     * @return 查询得到的文章
     */
    List<Article> findByBrowseGreater(long time, boolean withBLOB);

    /**
     * 选择性的插入文章内容
     *
     * @param article 插入的文章
     * @return 影响数据的条数
     */
    @Transactional
    int insertSelective(Article article);

    /**
     * 通过文章id删除文章
     *
     * @param id 文章的id
     * @return 影响的数据条数
     */
    @Transactional
    int deleteById(long id);

    /**
     * 删除一段id的文章信息
     *
     * @param idList 文章id集合
     * @return 影响的数据条数
     */
    @Transactional
    int deleteByIdList(List<Long> idList);

    /**
     * 根据文章标题删除文章
     *
     * @param title 文章的标题
     * @return 影响的数据条数
     */
    @Transactional
    int deleteByTitle(String title);

    /**
     * 删除指定日期内的文章
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 影响的条数
     */
    @Transactional
    int deleteBetweenDate(Date start, Date end);

    /**
     * 删除指定日期之后的文章
     *
     * @param date 指定的日期
     * @return 影响的数据条数
     */
    @Transactional
    int deleteAfterDate(Date date);

    /**
     * 删除指定日期之前的文章
     *
     * @param date 指定的日期
     * @return 影响数据的条数
     */
    @Transactional
    int deleteBeforeDate(Date date);

    /**
     * 更新文章但是不包括BLOB大文件
     *
     * @param article 更新后的文章内容
     * @return 影响的数据条数
     */
    @Transactional
    int updateAllWithoutBLOBById(Article article);

    /**
     * 通过文章id全部更新文章
     *
     * @param article 更新的文章
     * @return 影响的数据条数
     */
    @Transactional
    int updateAllById(Article article);

    /**
     * 通过文章id更新文章的部分内容
     *
     * @param article 更新的文章
     * @return 影响的数据条数
     */
    @Transactional
    int updateSelectiveById(Article article);
}
