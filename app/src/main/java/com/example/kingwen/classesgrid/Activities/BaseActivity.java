package com.example.kingwen.classesgrid.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kingwen on 2016/3/14.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.activities.add(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.activities.remove(this);
    }
}
