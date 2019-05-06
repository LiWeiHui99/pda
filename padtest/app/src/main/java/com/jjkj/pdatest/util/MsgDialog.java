package com.jjkj.pdatest.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;

import com.jjkj.pdatest.Activity.EmpowerActivity;
import com.jjkj.pdatest.R;

public class MsgDialog extends AlertDialog {
    public MsgDialog(Context context,String title,String msg) {
        super(context);
        MsgDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
                Intent intent = new Intent(getContext(),EmpowerActivity.class);
                getContext().startActivity(intent);
            }
        });
        builder.show();
    }
}
