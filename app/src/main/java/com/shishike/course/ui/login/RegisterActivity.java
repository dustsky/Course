package com.shishike.course.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shishike.course.R;
import com.shishike.course.base.BaseActivity;
import com.shishike.course.db.UserOper;

public class RegisterActivity extends BaseActivity {

    private EditText nameET;
    private EditText passwordET;
    private EditText passwordConfirmET;
    private Button registerBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameET = findViewById(R.id.ed_name);
        passwordET = findViewById(R.id.ed_password);
        passwordConfirmET = findViewById(R.id.ed_password_confirm);
        registerBtn = findViewById(R.id.bt_register);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    public void register(){
        String userName = nameET.getText().toString();
        String password = passwordET.getText().toString();
        String confirmPasswrod = passwordConfirmET.getText().toString();
        if (userName.isEmpty()) {
            Toast.makeText(this,R.string.user_name_empty_tip,Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.isEmpty() || confirmPasswrod.isEmpty()){
            Toast.makeText(this,R.string.user_password_empty_tip,Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.equals(confirmPasswrod)){
            Toast.makeText(this,R.string.user_password_is_different,Toast.LENGTH_SHORT).show();
            return;
        }
        UserOper userOper = new UserOper();
        userOper.saveUserToDB(userName,password);
    }
}
