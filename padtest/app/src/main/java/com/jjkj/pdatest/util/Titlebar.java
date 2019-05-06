package com.jjkj.pdatest.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jjkj.pdatest.Activity.EmpowerActivity;
import com.jjkj.pdatest.R;

import javax.security.auth.login.LoginException;

/**
 * Titlebar
 *
 * @author lwh
 * @date 2019/4/30
 */
public class Titlebar extends LinearLayout {
    private RelativeLayout titlebarBar;
    private Button titlebarMenu;
    private TextView titlebarTitle;
    private View v;
    public Titlebar(Context context,AttributeSet attrs) {
        super(context, attrs);
        v = LayoutInflater.from(context).inflate(R.layout.util_tiltebar,this);
        init();
    }

    private void init() {
        titlebarBar = v.findViewById(R.id.titlebar_bar);
        titlebarMenu = v.findViewById(R.id.titlebar_menu);
        titlebarTitle = v.findViewById(R.id.titlebar_title);
        titlebarMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),EmpowerActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
    public void setTitlebarColor(String color){
        titlebarBar.setBackgroundColor(Color.parseColor(color));
    }
    public void setBtnVisiblity(boolean b){
        if(!b){
            titlebarMenu.setVisibility(View.GONE);
        }
    }
    public void setTitleText(String titletext){
        titlebarTitle.setText(titletext);
    }
}
