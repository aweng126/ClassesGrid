package com.example.kingwen.classesgrid.Utils;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.kingwen.classesgrid.Beans.*;
import com.example.kingwen.classesgrid.Beans.Class;

/**
 * Created by kingwen on 2016/3/16.
 */
public class ShareClass extends Application{

    private static SharedPreferences preferences;
    private static  SharedPreferences.Editor editor;

    public static SharedPreferences.Editor getEditor() {
        return editor;
    }

    public static void setEditor(SharedPreferences.Editor editor) {
        ShareClass.editor = editor;
    }

    public static SharedPreferences getPreferences() {
        return preferences;
    }

    public static void setPreferences(SharedPreferences preferences) {
        ShareClass.preferences = preferences;
    }

    public static  void saveMyClass(int id,Class myClass){

        if(preferences.contains("name"+id)&&preferences.contains("place"+id)&&preferences.contains("teacher"+id)){
            editor.remove("name"+id);
            editor.remove("place"+id);
            editor.remove("teacher"+id);

            Log.d("Share","remove()");
        }
        String name=myClass.getClassName();
        String place=myClass.getClassPlace();
        String teacher=myClass.getClassTeacher();
        editor.putString("name"+id,name);
        editor.putString("place"+id,place);
        editor.putString("teacher"+id,teacher);
        editor.commit();

        Log.d("ShareClass()", "getMyClass()");

    }


    public static Class getMyClass(int id){
        String name=preferences.getString("name"+id,"");
        String place=preferences.getString("place"+id,"");
        String time=preferences.getString("teacher"+id,"");
        Class c=new Class(name,place,time);

        Log.d("ShareClass()","saveMyClass()");

        return c;
    }


}
