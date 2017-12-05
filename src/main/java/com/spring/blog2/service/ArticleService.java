package com.spring.blog2.service;

<<<<<<< HEAD
import com.spring.blog2.obj.Article;
=======
import com.spring.blog2.entity.Article;
>>>>>>> be0f1053a50714b07ddbfdfe83a2dd2129fcde1d
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
<<<<<<< HEAD
 * 该类对文章进行饭管理
 *
 * @author Smy
=======
 * 对文章进行增删改除操作的接口类
 *
 * @author SongMengYuan
>>>>>>> be0f1053a50714b07ddbfdfe83a2dd2129fcde1d
 * @version 1.0
 */
public interface ArticleService {
    /**
<<<<<<< HEAD
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
=======
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
>>>>>>> be0f1053a50714b07ddbfdfe83a2dd2129fcde1d
     */
    long countByDate(Date start, Date end);

    /**
<<<<<<< HEAD
     * 统计某个时间之后的文章数目
     *
     * @param date 指定的日期
     * @return 查询的到的文章数目
=======
     * 统计特定时间之后所有的文章数目
     *
     * @param date 指定的时间
     * @return 指定时间后的文章数目
>>>>>>> be0f1053a50714b07ddbfdfe83a2dd2129fcde1d
     */
    long countByDateAfter(Date date);

    /**
<<<<<<< HEAD
     * 统计指定日期之前的所有文章
     *
     * @param date 指定的日期
     * @return 查询得到的条数
=======
     * 统计在指定日期之前的文章
     *
     * @param date 指定的日期
     * @return 查出文章的数目
>>>>>>> be0f1053a50714b07ddbfdfe83a2dd2129fcde1d
     */
    long countByDateBefore(Date date);

    /**
<<<<<<< HEAD
     * 根据文章id查询文章
     *
     * @param id 文章的id
     * @return 查询得到的文章
=======
     * 通过文章的id查找文章
     *
     * @param id 文章的id
     * @return 查询到的文章
>>>>>>> be0f1053a50714b07ddbfdfe83a2dd2129fcde1d
     */
    Article findById(long id);

    /**
<<<<<<< HEAD
     * 列出所有的文章
     *
     * @return 返回所有的文章对象
=======
     * 查询出所有的文章
     *
     * @return 返回查询出来的所有的文章
>>>>>>> be0f1053a50714b07ddbfdfe83a2dd2129fcde1d
     */
    List<Article> findAll();

    /**
<<<<<<< HEAD
     * 带有分页功能的查询所有文章
     *
     * @param rowBounds 分页的参数
     * @return 列出所有的文章
=======
     * 查询所有的文章，带有分页效果
     *
     * @param rowBounds 分页效果
     * @return 返回查询具有分页效果的文章
>>>>>>> be0f1053a50714b07ddbfdfe83a2dd2129fcde1d
     */
    List<Article> findAll(RowBounds rowBounds);

    /**
<<<<<<< HEAD
     * 根据一群id查询一群文章
     *
     * @param list 文章id的集合
     * @return 一群文章
=======
     * 查询出某一段id区间内的文章
     *
     * @param list 要查询的id区间
     * @return 查询到的文章
>>>>>>> be0f1053a50714b07ddbfdfe83a2dd2129fcde1d
     */
    List<Article> findByIdList(List<Long> list);

    /**
<<<<<<< HEAD
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
=======
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
     * 分局分类名称查询分类文章
     * @param classifyName
     * @return
     */
    List<Article> findByClassify(String classifyName);

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
>>>>>>> be0f1053a50714b07ddbfdfe83a2dd2129fcde1d
}
