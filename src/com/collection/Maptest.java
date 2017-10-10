package com.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Maptest {

    /*
    用来承装学生类型对象
     */
    public Map<String,Student> students;

    /*
    在构造器中初始化students属性
     */

    public Maptest(){
        this.students=new HashMap<String, Student>();
    }


    /*
    *测试添加：输入学生ID，判断是否被占用
    *若未被占用，则输入姓名，创建新学生对象
    * 并且添加到students中
     */
    public void testPut(){
        Scanner console =new Scanner(System.in);
        int i=0;
        while (i<3){
            System.out.println("请输入学生ID：");
            String ID=console.next();
            //判断该ID是否被占用
            Student student =students.get(ID);
            if (student==null){
                System.out.println("请输入学生姓名：");
                String name=console.next();
                //创建新的学生对象
                Student student1=new Student(ID,name);
                //通过调用students的put方法，添加ID-学生映射
                students.put(ID,student1);
                System.out.println("成功添加学生："+students.get(ID).name);
                i++;
            }else {
                System.out.println("该学生ID已经被占用");
                continue;
            }
        }
    }
    public void testKeyset(){
        //通过keyset方法，返回Map中的所有键的Set集合
        Set<String> keyset =students.keySet();
        //取得student的容量
        System.out.println("总攻有："+students.size()+"个学生");
        for (String stuId:keyset) {
            Student student =students.get(stuId);
            if (student!=null)
                System.out.println("学生："+student.name);
        }
    }
    /*
    测试删除Map中的映射
     */
    public void testRemove(){

        Scanner console=new Scanner(System.in);
while (true){
    System.out.println("请输入要删除的学生ID:");
    String ID=console.next();
    //判断该ID是否有对应的对象
    Student student=students.get(ID);
    if(student==null){
        System.out.println("该ID不存在");
        continue;
    }
    students.remove(ID);
    System.out.println("成功删除学生："+student.name);
    break;
}
    }

    /*
    *通过entryset方法来遍历Map
     */
    public void testEntrySet(){
        Set<Map.Entry<String, Student>> entrySet=students.entrySet();
        for (Map.Entry<String, Student> entry:entrySet
             ) {
            System.out.println("取得键："+entry.getValue().name);
        }
    }

    /**
     * 利用put方法修改Map中的已有映射
     */
    public void testModify(){
        System.out.println("请输入要修改的学生ID:");
        Scanner console =new Scanner(System.in);
        while (true){
            String stuID=console.next();
            //从student中查找该学生ID对应的学生对象
            Student student =students.get(stuID);
            if (student==null){
                System.out.println("该ID不存在！重新输入");
                continue;
            }
            //提示当前对应的学生对象的姓名
            System.out.println("当前该学生的姓名为："+student.name);
            //提示输入新的学生姓名，来修改已有的映射
            System.out.println("请输入新的学生姓名");
            String newName=console.next();
            Student newStudent = new Student(stuID,newName);
            students.put(stuID,newStudent);
            System.out.println("修改成功");
            break;
        }
    }

    public static void main(String[] args) {
        Maptest maptest=new Maptest();
        maptest.testPut();
        maptest.testKeyset();
    // maptest.testRemove();
     //  maptest.testEntrySet();
        maptest.testModify();
        maptest.testEntrySet();
      //  maptest.testEntrySet();
    }
}
