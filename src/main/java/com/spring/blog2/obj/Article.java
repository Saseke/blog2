package com.spring.blog2.obj;

import java.util.Date;

/**
 * 博客的文章类
 * @author SongMengYuan
 * @version 1.0
 */
public class Article {
    private Integer id;

    private String title;

    private String author;

    private Date createtime;

    private Date updatetime;

    private Integer browsetime;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getBrowsetime() {
        return browsetime;
    }

    public void setBrowsetime(Integer browsetime) {
        this.browsetime = browsetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}