/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.springjdbccrudoperation;

import java.util.List;

/**
 *
 * @author HP
 */
public interface StudentDAO {
    int insert(Student student);
    int update(int id,Student student);
    int delete(int id);
    Student getStudent(int id);
    List<Student> getStudents();
    
}
