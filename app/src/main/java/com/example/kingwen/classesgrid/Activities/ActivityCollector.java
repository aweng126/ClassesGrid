package com.example.kingwen.classesgrid.Activities;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingwen on 2016/3/14.
 * 活动收集器，用于存储所有的活动
 */
public class ActivityCollector {

    //建立一个队列用于存储我们的所有的活动
    public  static List<Activity> activities =new ArrayList<Activity>();

    //加入一个activity
    public  static  void addActivity(Activity activity){
        activities.add(activity);
    }

    //移除一个activity
    public  static  void moveActivity(Activity activity){
        activities.remove(activity);
    }

   //结束所有活动
    public static  void finishAll(){

        for(Activity activity: activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }

    }

}
