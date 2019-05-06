package com.jjkj.pdatest.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjkj.pdatest.R;

/**
 * LoginActivity
 *
 * @author lwh
 * @date 2019/4/29
 */
public class RegisterActivity extends AppCompatActivity {
    private ImageView RgEditHead;
    private EditText RgCheckStationId;
    private EditText RgWebIp;
    private EditText RgWebPort;
    private Button RgRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        RgRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            }
        });
    }

    private void init() {
        RgEditHead = (ImageView) findViewById(R.id.Rg_EditHead);
        RgCheckStationId = (EditText) findViewById(R.id.Rg_CheckStationId);
        RgWebIp = (EditText) findViewById(R.id.Rg_WebIp);
        RgWebPort = (EditText) findViewById(R.id.Rg_WebPort);
        RgRegister = (Button) findViewById(R.id.Rg_Register);

    }
}
