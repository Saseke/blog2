package com.spring.blog2.service;

import com.spring.blog2.entity.Comment;

/**
 * 评论操作的接口
 */
public interface CommentService {
    /**
     * 添加评论
     *
     * @param comment 评论 对象
     * @return 影响数据的条数
     */
    int add(Comment comment);

    /**
     * 根据评论的id进行删除操作
     *
     * @param id 删除评论的id
     * @return 影响的数据的条数
     */
    int delete(long id);
}
