package com.shishike.course.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.shishike.course.MainActivity;
import com.shishike.course.R;
import com.shishike.course.db.UserOper;
import com.shishike.course.base.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private Button mLoginBtn;
    private TextView mGoRegisterTV;
    private EditText nameET;
    private EditText passwordET;
    private UserOper userOper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialData();
        mLoginBtn = findViewById(R.id.bt_login);
        mGoRegisterTV = findViewById(R.id.tv_goRegister);
        nameET = findViewById(R.id.ed_name);
        passwordET = findViewById(R.id.ed_password);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        mGoRegisterTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goRegister();
            }
        });
    }

    private void initialData(){
        userOper = new UserOper();
    }

    private void goRegister(){
        final Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    void login(){

        String userName = nameET.getText().toString();
        String userPassword = passwordET.getText().toString();
        if (userName.isEmpty()){
            Toast.makeText(this,R.string.user_name_empty_tip,Toast.LENGTH_SHORT).show();
            return;
        }
        if (userPassword.isEmpty()){
            Toast.makeText(this,R.string.user_password_empty_tip,Toast.LENGTH_SHORT).show();
            return;
        }

        if (!userOper.existUser(userName)) {
            Toast.makeText(this,R.string.user_noExist_tip,Toast.LENGTH_SHORT).show();
            return;
        }

        if (userOper.verifyUser(userName,userPassword)){
            //登陆成功
            goMainActivity();
            return;
        }
        new AlertView("", this.getString(R.string.user_name_enter_wrong), null, new String[]{"知道了"},
                null,
                this, AlertView.Style.Alert, new OnItemClickListener(){
            public void onItemClick(Object o,int position){

            }
        }).show();
    }

    private void autoLogin(){

        if (userOper.lastLoginUser() != null){
            goMainActivity();
        }
    }

    void goMainActivity(){
        final Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}
