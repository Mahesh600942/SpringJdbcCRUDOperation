/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.springjdbccrudoperation;

import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringJdbcCrudOperation {

    public static void main(String[] args) {
        
        ApplicationContext c=new AnnotationConfigApplicationContext(JavaConfig.class);
        
        StudentDAOImpl j = c.getBean(StudentDAOImpl.class);
        
        System.out.println(j.getStudents());
//        ApplicationContext c = new ClassPathXmlApplicationContext("config.xml");
//        StudentDAOImpl j = c.getBean("impl", StudentDAOImpl.class);
        int i=0;
        do {
            System.out.println("1.Insert\n2.Update\n3.Delete\n4.Get Singal\n5.Get All\n6.Exit");
            System.out.println("enter your choice");
            Scanner sc = new Scanner(System.in);
             i = sc.nextInt();

            switch (i) {
                case 1:
                    System.err.println("enter student info");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String city = sc.next();
                    j.insert(new Student(id, name, city));
                    break;

                case 2:
                    System.err.println("enter student id");
                    int idu = sc.nextInt();
                    System.err.println("enter student name and city");
                    String nameu = sc.next();
                    String cityu = sc.next();
                    j.update(idu, new Student(nameu, cityu));
                    break;

                case 3:
                    System.err.println("enter student id");
                    int idd = sc.nextInt();

                    j.delete(idd);
                    break;
                case 4:
                    System.err.println(" enter student id");
                    int ids = sc.nextInt();
                    System.out.println(j.getStudent(ids));

                    break;
                    
                     case 5:
                    
                    System.out.println(j.getStudents());

                    break;
                    
                default:
                    System.err.println(" enter correct choice");
                    break;

            }

        } while (i!=6);

    }
}
