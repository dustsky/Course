package com.shishike.course.bean;

import io.realm.RealmObject;

public class User extends RealmObject {
    public String name;
    public String password;
    public boolean isLogout;
}
