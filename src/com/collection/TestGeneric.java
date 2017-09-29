package com.collection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

    /*
    带有泛型--Course的List类型属性
     */
    public List<Course> courses;

    /*
    初始化courses属性
     */
    public TestGeneric(){
        this.courses=new ArrayList<Course>();
    }
/*
测试添加
 */
    public void testAdd(){
        Course cr1=new Course("1","大学语文");
        courses.add(cr1);
        //泛型集合中，不能添加泛型规定的类型意外的对象，否则会报错
        //courses.add("能否添加一些奇怪的东西呢");
        Course cr2=new Course("2","Java基础");
        courses.add(cr2);
    }

    public void testForEach(){
        for (Course cr:courses){
            System.out.println(cr.id+":"+cr.name);
        }
    }
    public static void main(String[] args){
        TestGeneric testGeneric =new TestGeneric();
        testGeneric.testAdd();
        testGeneric.testForEach();



    }
}
