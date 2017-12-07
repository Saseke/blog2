package com.spring.blog2.obj;

import java.util.Date;

public class Article {
    private Long id;

    private String title;

    private String authorName;

    private Date createtime;

    private Date updatetime;

    private Integer browsetime;

    private Long authorId;

    private Long categoryId;

    private String content;

    private String shortTime;

    public String getShortTime() {
        return shortTime;
    }

    public void setShortTime(String shortTime) {
        this.shortTime = shortTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}