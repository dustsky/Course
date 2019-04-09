package com.shishike.course.db;

import com.shishike.course.bean.User;

import java.util.jar.Attributes;

import io.realm.Realm;
import io.realm.RealmResults;

public class UserOper extends BaseOper{

    public boolean existUser(String userName){
        final RealmResults<User> users = realm.where(User.class).equalTo("name",userName).findAll();
        return users.size() != 0;
    }

    public User lastLoginUser(){
        final RealmResults<User> users = realm.where(User.class).findAll();
        return users.first();
    }

    public boolean verifyUser(String userName,String userPassword){

        final RealmResults<User> users = realm.where(User.class).equalTo("name",userName).equalTo("password",userPassword).findAll();
        return users.size() != 0;
    }

    public void saveUserToDB(final String userName,final String userPassword){
        if (existUser(userName)){
            return;
        }
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User user = realm.createObject(User.class); // Persist unmanaged objects
                user.name = userName;
                user.password = userPassword;
            }
        });
    }
}
