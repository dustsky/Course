package com.shishike.course.db;

import android.content.Context;

import com.shishike.course.bean.Base;

import io.realm.Realm;

public class BaseOper <T extends Base>{

    protected Realm realm = Realm.getDefaultInstance();

    public void Base(){

    }
    public void saveToDb(T obj){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(obj);
        realm.commitTransaction();
    }
}
