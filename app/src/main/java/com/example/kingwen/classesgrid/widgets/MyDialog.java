package com.example.kingwen.classesgrid.widgets;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.kingwen.classesgrid.Beans.Class;

import com.example.kingwen.classesgrid.R;

/**
 * Created by kingwen on 2016/3/13.
 * 自定义dialog，用于用户点击课程相应位置之后可以弹出一个框，
 * 然后进行自定义课程
 */
public class MyDialog extends Dialog {

    //定义回调事件
    public interface  OnMyDialogListener{

        public void back(Class diaClass);

    }

    //课程名字
    private EditText et_className_dialog;
    //课程地点
    private  EditText et_classPlace_dialog;
    //课程时间
    private  EditText et_classTime_dialog;

    //确定按钮
    private Button btn_confirrm;
    //取消按钮
    private Button btn_cancel;
    //dialog的名字
    private  String dialogname;
    //回调的listener
    private  OnMyDialogListener onMyDialogListener;

    //自定义的dialog的构造方法
    public MyDialog(Context context,String name,OnMyDialogListener onMyDialogListener) {
        super(context);
        this.dialogname=name;
        this.onMyDialogListener=onMyDialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        setTitle(dialogname);

        initViews();

        initListener();
    }

    private void initListener() {
        btn_confirrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String className=et_className_dialog.getText().toString();
                String classPlace=et_classPlace_dialog.getText().toString();
                String classTime=et_classTime_dialog.getText().toString();

                if((!"".equals(className)&&(!"".equals(classPlace))&&(!"".equals(classTime)))){
                    Class myclass=new Class(className,classPlace,classTime);
                    onMyDialogListener.back(myclass);
                    MyDialog.this.dismiss();
                }
                Log.d("回调back","MYDialog（）");

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDialog.this.dismiss();

            }
        });
    }

    private void initViews() {
        et_className_dialog= (EditText) findViewById(R.id.class_name_dialog);
        et_classPlace_dialog= (EditText) findViewById(R.id.class_place_dialog);
        et_classTime_dialog= (EditText) findViewById(R.id.class_time_dialog);

        btn_confirrm= (Button) findViewById(R.id.btn_confirm_dialog);
        btn_cancel= (Button) findViewById(R.id.btn_cancel_dialog);

    }
}
