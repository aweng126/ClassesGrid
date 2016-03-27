package com.example.kingwen.classesgrid.Utils;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.example.kingwen.classesgrid.Activities.ActivityCollector;

/**
 * Created by kingwen on 2016/3/14.
 */
public class ExitLineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        //利用builder来建立自己的dialog。（当然这里的dialog也是可以自己定义）
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(context);
        //设置标题
        dialogBuilder.setTitle("通知");
        dialogBuilder.setMessage("你已经成功的退出了课程格子");
        dialogBuilder.setCancelable(false);

        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishAll();
            }
        });

        AlertDialog alertDialog=dialogBuilder.create();
        alertDialog.show();




    }
}
