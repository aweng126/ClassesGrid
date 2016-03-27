package com.example.kingwen.classesgrid.Beans;

/**
 * Created by kingwen on 2016/3/13.
 */

/*
* 单个课程的类
* */
public class Class {
    //课程名字
    private String className;
    //课程时间
    private String classTeacher;
    //课程地点
    private String classPlace;

    //本节课是否已经设定过
    private boolean isSet=false;

    public boolean isSet() {
        return isSet;
    }

    public void setIsSet(boolean isSet) {
        this.isSet = isSet;
    }


    public Class(){
        this.className="";
        this.classPlace="";
        this.classTeacher="";
    }

    public Class(String className, String classPlace, String classTeacher) {
        this.className = className;
        this.classPlace = classPlace;
        this.classTeacher = classTeacher;
        this.isSet=true;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public String getClassPlace() {
        return classPlace;
    }

    public void setClassPlace(String classPlace) {
        this.classPlace = classPlace;
    }
}
