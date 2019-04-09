package com.shishike.course.bean;

import com.shishike.course.base.BaseBean;
import java.util.List;

public class ChapterBean extends BaseBean {
    private String name;
    private List<ClassBean> classes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClassBean> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassBean> classes) {
        this.classes = classes;
    }
}
