package com.jjkj.pdatest.Activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jjkj.pdatest.R;
import com.journeyapps.barcodescanner.CaptureActivity;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

import java.util.List;

/**
 *EmpowerActivity
 *
 * @author lwh
 * @date 2019/4/30
 */
public class EmpowerActivity extends AppCompatActivity implements View.OnClickListener {
    private Button EmScan;
    private Button EmCancel;
    private Button EmSave;
    private TextView Emcode;
    private int REQUEST_CODE_SCAN = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empower);
        init();
    }
    private void init() {
        EmScan = (Button) findViewById(R.id.Em_scan);
        EmCancel = (Button) findViewById(R.id.Em_cancel);
        EmSave = (Button) findViewById(R.id.Em_save);
        Emcode = (TextView)findViewById(R.id.Em_code);
        EmScan.setOnClickListener(this);
        EmSave.setOnClickListener(this);
        EmCancel.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Em_scan:
                scan();
                break;
            case R.id.Em_cancel:
                break;
            case R.id.Em_save:
                break;
                default:
                    break;
        }
    }
    private void scan(){
        AndPermission.with(this)
                .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Intent intent = new Intent(EmpowerActivity.this,CaptureActivity.class);
                        startActivityForResult(intent, REQUEST_CODE_SCAN);
                    }
                })
                .onDenied(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Uri packageURI = Uri.parse("package:" + getPackageName());
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Toast.makeText(EmpowerActivity.this, "没有权限无法扫描,请先允许拍照权限", Toast.LENGTH_LONG).show();
                    }
                }).start();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra("csodedContent");
                Emcode.setText("扫描结果为：" + content);
            }
        }
    }
}
