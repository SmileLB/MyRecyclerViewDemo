package com.example.administrator.myrecyclerviewdemo.bean;

/**
 * Created by LiBing
 * on 2017/9/4 0004
 * describe:
 */

public class SimpleBean {

    private String title;
    private String content;
    private String url;

    public SimpleBean() {
    }

    public SimpleBean(String title, String content, String url) {
        this.title = title;
        this.content = content;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
