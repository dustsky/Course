package com.shishike.course.bean;

import com.shishike.course.base.BaseBean;

import java.util.List;

public class SubjectBean extends BaseBean {
    private String icon;
    private String name;
    private List<ChapterBean> chapters;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChapterBean> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterBean> chapters) {
        this.chapters = chapters;
    }
}
