package com.jjkj.pdatest.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jjkj.pdatest.R;
import com.jjkj.pdatest.util.Titlebar;

/**
 * LoginActivity
 *
 * @author lwh
 * @date 2019/4/29
 */
public class LoginActivity extends AppCompatActivity {
    private EditText LogAccount;
    private EditText LogPassword;
    private Button LogLogin;
    private Titlebar LogTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        LogTitle = findViewById(R.id.Log_Title);
        LogTitle.setTitleText("登录");
        LogTitle.setBtnVisiblity(false);
        LogTitle.setTitlebarColor("#f1f1f1");
        LogAccount = findViewById(R.id.Log_Account);
        LogPassword = findViewById(R.id.Log_Password);
        LogLogin = findViewById(R.id.Log_Login);
        LogLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
