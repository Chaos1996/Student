package com.collection;

import sun.plugin.javascript.navig.Array;

import java.util.*;

/*
备选课程类
 */
public class ListTest {
    /*
  用于存放备选课程的List
   */
    public List coursesToselect;


    public ListTest(){
        this.coursesToselect=new ArrayList();
    }
    /*
    用于往courseToSelect中添加备选课程
     */
    public void testAdd(){
        //创建一个课程对象，并通过调用add方法，添加到备选课程List中
    Course cr1 =new Course("1","数据结构");
        coursesToselect.add(cr1);
        Course temp =(Course) coursesToselect.get(0);
        System.out.println("添加了课程："+temp.id+":"+temp.name);

    Course cr2 =new Course("2","C语言");
    coursesToselect.add(0,cr2);
    Course temp2 =(Course)coursesToselect.get(0);
        System.out.println("添加了课程："+temp2.id+":"+temp2.name);

  //  Course cr3 =new Course("3","JAVA教程");
  //  coursesToselect.add(3,cr3);

      Course[] course ={new Course("3","离散数学"),
                        new Course("4","汇编语言")};
        coursesToselect.addAll(Arrays.asList(course));
        Course temp3 =(Course)coursesToselect.get(2);
        Course temp4 =(Course)coursesToselect.get(3);
        System.out.println("添加了两门:"+temp3.id+":"+temp3.name+";"+temp4.id+":"+temp4.name);

        Course[] course2 ={new Course("5","5555"),
                new Course("6","6666")};
        coursesToselect.addAll(2,Arrays.asList(course2));
        Course temp5 =(Course)coursesToselect.get(2);
        Course temp6 =(Course)coursesToselect.get(3);
        System.out.println("添加了两门:"+temp5.id+":"+temp5.name+";"+temp6.id+":"+temp6.name);
    }

    public void testGet(){
        int size =coursesToselect.size();
        System.out.println("有如下课程");
        for (int i=0;i<size;i++){
           Course cr =(Course) coursesToselect.get(i);
            System.out.println("课程："+cr.id+":"+cr.name);
        }
    }
/*
通过迭代器来遍历List
 */
    public void testIterator(){
        //通过集合的iterator方法，取得迭代器的实例
        Iterator it= coursesToselect.iterator();
        System.out.println("有如下课程（通过迭代器访问）");
        while (it.hasNext()){
            Course cr=(Course)it.next();
            System.out.println("课程："+cr.id+":"+cr.name);
        }
    }
   public void testForEach(){
       System.out.println("有如下课程（通过for each访问）");
        for(Object obj:coursesToselect){
            Course cr =(Course)obj;
            System.out.println("课程："+cr.id+":"+cr.name);
        }
   }

   /*
   修改List中的元素
    */
   public void testModify(){
       coursesToselect.set(4,new Course("7","毛概"));
   }
/*
删除List中的元素
 */
   public void testRemote(){
    //  Course  cr= (Course) coursesToselect.get(4);
     //  System.out.println("我是课程："+cr.id+":"+cr.name+"我即将被删除");
    //  coursesToselect.remove(cr);
       // coursesToselect.remove(4);
       System.out.println("即将删除4。5位置上的课程");
       Course[] courses={(Course) coursesToselect.get(4),(Course)coursesToselect.get(5)};
        coursesToselect.removeAll(Arrays.asList(courses));
       System.out.println("成功删除课程！");
       testForEach();
   }

   /*
   往List中添加一些奇怪的东西
    */
   public void testType(){
       System.out.println("能否往LIst中添加奇怪的东西呢？");
       coursesToselect.add("无关的字符串");
   }


    public static void main(String[] args){
        ListTest lt=new ListTest();
        lt.testAdd();
        lt.testType();
        lt.testForEach();
        // lt.testGet();
        //  lt.testIterator();
        //  lt.testForEach();
        //  lt.testModify();
        //  lt.testForEach();
        //  lt.testRemote();
    }
}
