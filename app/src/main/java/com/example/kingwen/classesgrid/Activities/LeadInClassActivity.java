package com.example.kingwen.classesgrid.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kingwen.classesgrid.R;

/**
 * Created by kingwen on 2016/3/16.
 *
 */
public class LeadInClassActivity extends BaseActivity  {

    //学号输入框
    private EditText et_inputNumber;
    //密码输入框
    private EditText et_inputPassword;
    //取消按钮
    private Button btn_cancel;
    //确认按钮
    private  Button btn_confirm;


    //得到我们学号文本框中的内容
    private  String myNumber;
    //得到我们的密码的功能
    private  String myPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.leadinclass_activity);

        initViews();

        initDatas();

        initListener();

    }

    private void initDatas() {
        myNumber=et_inputNumber.getText().toString();
        myPassword=et_inputPassword.getText().toString();

        if(!("".equals(myNumber))&&!("".equals(myPassword))){
          /*
          得到了我们的用户名和密码，接下来就是进行网络操作
          */






        }else{
            Toast.makeText(this,"学号和密码都不能为空",Toast.LENGTH_LONG).show();
        }
    }

    private void initListener() {

    }

    private void initViews() {
        et_inputNumber= (EditText) findViewById(R.id.et_number_leadinclass);
        et_inputPassword= (EditText) findViewById(R.id.et_password_leadinclass);
        btn_cancel= (Button) findViewById(R.id.btn_cancel_leadinclass);
        btn_confirm= (Button) findViewById(R.id.btn_confirm_leadinclass);
    }
}
