package com.shishike.course.bean;

import com.shishike.course.base.BaseBean;

import java.util.List;

public class ClassBean extends BaseBean {
    private String name;
    private String content;
    private String images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
