package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {

    public List<Course> coursesToselect;

    public SetTest() {
        coursesToselect = new ArrayList<Course>();
    }

    public void testAdd111() {
        //创建一个课程对象，并通过调用add方法，添加到备选课程List中
        Course cr1 = new Course("1", "数据结构");
        coursesToselect.add(cr1);
        Course temp = (Course) coursesToselect.get(0);

        Course cr2 = new Course("2", "C语言");
        coursesToselect.add(0, cr2);
        Course temp2 = (Course) coursesToselect.get(0);


        Course[] course = {new Course("3", "离散数学"),
                new Course("4", "汇编语言")};
        coursesToselect.addAll(Arrays.asList(course));
        Course temp3 = (Course) coursesToselect.get(2);
        Course temp4 = (Course) coursesToselect.get(3);


        Course[] course2 = {new Course("5", "5555"),
                new Course("6", "6666")};
        coursesToselect.addAll(2, Arrays.asList(course2));
        Course temp5 = (Course) coursesToselect.get(2);
        Course temp6 = (Course) coursesToselect.get(3);

    }

    public void testForEach() {
        System.out.println("有如下课程（通过for each访问）");
        for (Object obj : coursesToselect) {
            Course cr = (Course) obj;
            System.out.println("课程：" + cr.id + ":" + cr.name);
        }
    }


    public static void main(String[] args) {
        SetTest setTest = new SetTest();
        setTest.testAdd111();
        setTest.testForEach();
        Student student =new Student("1","小名");
        System.out.println("欢迎学生"+student.name+"选课");
        Scanner console=new Scanner(System.in);
        for (int i=0;i<3;i++){
            System.out.println("请输入课程ID");
            String courseId=console.next();
            for (Course cr:setTest.coursesToselect
                 ) {
            if (cr.id.equals(courseId)){
                student.courses.add(cr);
                /*
                *set中，添加某个对象，
                * 无论添加多少次，
                * 最终只保留一个该对象（的引用）
                * 并且，保留的是第一次添加的那一个
                 */
             //   student.courses.add(null);
             //   student.courses.add(cr);
            }
            }
        }
      setTest.testForEachForSet(student);
    }

    public void testForEachForSet(Student student){

        System.out.println("共选了:"+student.courses.size()+"门课程");
        for (Course cr:student.courses
                ) {
            System.out.println("选择了课程："+cr.id+"："+cr.name);
        }
    }

}
