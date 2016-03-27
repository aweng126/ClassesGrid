package com.example.kingwen.classesgrid.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kingwen.classesgrid.Beans.Class;
import com.example.kingwen.classesgrid.R;

import java.util.List;

/*
* 每一个class块的适配器，包含三部分：课程名字，课程地点，课程时间
* 通过viewholder来进行了优化
*
* */
/**
 * Created by kingwen on 2016/3/12.
 */
public class ClassAdapter extends BaseAdapter {

    //一个类似于布局管理器的东西
    private LayoutInflater inflater;

    //构造上下文对象
    private Context mContext;

    //课程数据目录清单list
    private List<Class> classes;


    //是否第一次返回我们的数据
    private  boolean isFirst=true;

    //adapter的构造函数
    public  ClassAdapter(Context context,List<Class> classes){
        this.mContext=context;
        this.classes=classes;
        inflater=LayoutInflater.from(context);

        Log.d("classAdapter","classes构造函数成功");
    }


    @Override
    public int getCount() {
        //此处应该用一种比较和谐的方式俩得到我们的数据，应该是通过我们的数据库对象来进行操作

        return 35;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       ViewHolder viewHolder;
        View view;
        if(convertView==null){
            view=LayoutInflater.from(mContext).inflate(R.layout.class_item_layout, null);
            viewHolder=new ViewHolder();
            viewHolder.tv_name_class= (TextView) view.findViewById(R.id.name_class_item_layout);
            viewHolder.tv_place_class= (TextView) view.findViewById(R.id.place_class_item_layout);
            viewHolder.tv_teacher_class= (TextView)view.findViewById(R.id.teacher_class_item_layout);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }

      //这里是用我们list来进行更新的
        viewHolder.tv_name_class.setText(classes.get(position).getClassName());
        viewHolder.tv_place_class.setText(classes.get(position).getClassPlace());
        viewHolder.tv_teacher_class.setText(classes.get(position).getClassTeacher());

        Log.d("返回viewholder对象",classes.get(position).getClassName()+position);

        
         return view;
    }
}

/*
* 用于优化我们的适配器操作的东西
* */
 class ViewHolder{
     //课程名称
     public TextView tv_name_class;
     //课程地点
     public TextView tv_place_class;
     //授课老师
     public TextView tv_teacher_class;

 }