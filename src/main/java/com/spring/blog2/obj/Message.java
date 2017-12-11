package com.spring.blog2.obj;

/**
 * 控制主体
 */
public class Message {
    public Message(Object content) {
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
