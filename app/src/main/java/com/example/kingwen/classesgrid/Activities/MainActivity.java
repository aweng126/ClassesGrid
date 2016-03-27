package com.example.kingwen.classesgrid.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kingwen.classesgrid.Adapter.ClassAdapter;
import com.example.kingwen.classesgrid.Beans.Class;
import com.example.kingwen.classesgrid.R;
import com.example.kingwen.classesgrid.Utils.ShareClass;
import com.example.kingwen.classesgrid.widgets.MyDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    //建立我们的表格布局的对象
    private GridView gridView;

    //用于存储我们class的链表
   private List<Class> classes=new ArrayList<Class>(35);


    //适配器
    private ClassAdapter classAdapter;


    //全局变量
    private ShareClass shareClass;

    //
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        * 这是右上角的那个功能选择键，可以在之后进行item的添加，然后实现功能
        * */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        * 这里是悬浮按钮，也可以之后进行添加监听事件
        * */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //初始化控件
        initViews();

        Log.d("initviews()", "执行结束");

        //初始化数据
        initDatas();

        Log.d("initDatas()", "执行结束");

        //设置适配器
        initAdapters();

        Log.d("initAdapters()", "执行结束");

        //设置监听事件
        initListener();

        Log.d("initListeners()", "执行结束");

    }

    private void initListener() {

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //用于回传的时候保存我们的参数
                //添加每个课程的监听事件，可以实现添加，删除，修改三种操作（需要自定义dialog）。暂时处理先用于弹出一个提示框


                MyDialog dialog = new MyDialog(MainActivity.this, "请自己设定课程", new MyDialog.OnMyDialogListener() {

                    public void back(Class myClass) {

                        classes.get(position).setClassName(myClass.getClassName());
                        classes.get(position).setClassPlace(myClass.getClassPlace());
                        classes.get(position).setClassTeacher(myClass.getClassTeacher());


                        //得到我们更改后的数据
                        String name = classes.get(position).getClassName();
                        String place = classes.get(position).getClassPlace();
                        String teacher = classes.get(position).getClassTeacher();

                        Class mClass=new Class(name,place,teacher);
                        ShareClass.saveMyClass(position,myClass);



                    }
                });

                dialog.show();

                Toast.makeText(MainActivity.this, "id=" + id + "position=" + position, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initAdapters() {

        classAdapter=new ClassAdapter(this,classes);

        gridView.setAdapter(classAdapter);

    }

    /*
    * 初始化我们布局的文件数据，先从我们的数据库中提取到我们的list中，然后通过list进行构造我们的view
    * */

    private void initDatas() {

        Class indexClass;
        for(int j=0;j<35;j++){

            String name=ShareClass.getMyClass(j).getClassName();
            String place=ShareClass.getMyClass(j).getClassPlace();
            String teacher=ShareClass.getMyClass(j).getClassTeacher();

            indexClass=new Class(name,place,teacher);

            Log.d("读取数据"+j,name+"  "+place+" "+teacher);

            classes.add(indexClass);

        }
    }

    private void initViews() {

        //设置我们的表格布局
        gridView= (GridView) findViewById(R.id.class_gridView);

        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(2800,LinearLayout.LayoutParams.MATCH_PARENT);
        gridView.setLayoutParams(params);
        gridView.setColumnWidth(250);
        gridView.setHorizontalSpacing(10);
        gridView.setVerticalSpacing(10);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setNumColumns(7);


        //实例化我们的全局变量
        shareClass= (ShareClass)getApplication();
        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
        ShareClass.setPreferences(sharedPreferences);
        ShareClass.setEditor(sharedPreferences.edit());

        Log.d("实例化全局变量","实例化成功");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_inputMyClass_menu) {
            //从教务系统导入（爬虫+数据库）





            return true;
        }else if(id==R.id.action_introduce_menu){
            //介绍本程序（重建一个activity界面，用于介绍我们的程序）







        }else if(id==R.id.action_exit_menu){
            //退出操作
            //发出一条自定义的本地广播，然后进行所有activity的finish，使得用户下线
            Intent intent=new Intent("com.example.kingwen.classesgrid.EXItLINERECEIVER");
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

        Log.d("ondestory", "ondestory方法");

    }
}
