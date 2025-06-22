/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springjdbccrudoperation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
   

    @Override
    public int insert(Student student) {
        return jdbcTemplate.update("insert into student values(?,?,?)", student.getId(), student.getName(), student.getCity());
    }

    @Override
    public int update(int id, Student student) {
        return jdbcTemplate.update("update student set name=? ,city=? where id=?", student.getName(), student.getCity(), id);
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from student where id=?",id);
    }

    @Override
    public List<Student> getStudents() {
        ROwMapperImpl rOwMapperImpl = new ROwMapperImpl();
        return jdbcTemplate.query("select * from student", rOwMapperImpl);
    }
    @Override
    public Student getStudent(int id) {
        ROwMapperImpl rOwMapperImpl = new ROwMapperImpl();
        return jdbcTemplate.queryForObject("select * from student where id=?",rOwMapperImpl ,id);
    
    }


}
