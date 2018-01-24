package com.spring.blog2.obj;

import java.util.Date;

public class Category {
    private Long id;

    public Category() {
    }

    private String name;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Category(Long id, String name, Date createDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
    }

    public Category(String name, Date createDate) {

        this.name = name;
        this.createDate = createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}