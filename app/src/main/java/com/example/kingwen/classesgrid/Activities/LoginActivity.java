package com.example.kingwen.classesgrid.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kingwen.classesgrid.R;


/**
 * Created by kingwen on 2016/3/12.
 */
public class LoginActivity extends BaseActivity {
    //名字
    private EditText et_name;
    //密码
    private EditText et_password;
    //登录按钮
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        initViews();

    }


    private void initViews() {
        et_name= (EditText) findViewById(R.id.et_inputName);
        et_password= (EditText) findViewById(R.id.et_inputPassword);
        btn_login= (Button) findViewById(R.id.btn_login);

        Log.d("LoginActivity","initViews");

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * 测试方便，先不考虑我们的用户名是否正常输入
                * */

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();


               /* String name = et_name.getText().toString();
                String password = et_password.getText().toString();

                Log.d("LoginActivity", "name=" + name + "password=" + password);

                if (!("".equals(name)) && !("".equals(password))) {

                    Toast.makeText(LoginActivity.this,"注册成功正在登陆",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(LoginActivity.this, "密码不正确", Toast.LENGTH_LONG).show();
                    Log.d("if语句", "密码不正确");
                }*/


            }
        });
    }
}
