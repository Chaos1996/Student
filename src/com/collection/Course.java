package com.collection;


/*
课程类
 */
public class Course {
    public String id;
    public String name;

    public Course(String id,String name){
        this.id=id;
        this.name=name;
    }

    /*
    避免继承Course时候报错，新建一个无参构造器
     */
    public Course(){

    }
}
