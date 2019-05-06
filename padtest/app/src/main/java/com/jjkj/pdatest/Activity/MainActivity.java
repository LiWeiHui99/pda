package com.jjkj.pdatest.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjkj.pdatest.R;
import com.jjkj.pdatest.util.MsgDialog;

/**
 * MainActivity
 *
 * @author lwh
 * @date 2019/4/30
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        new MsgDialog(this,"提示","请先配置序列号!");
    }

    private void init() {

    }
}
