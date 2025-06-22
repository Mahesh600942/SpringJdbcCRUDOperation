/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springjdbccrudoperation;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author HP
 */
@Configuration
public class JavaConfig {
    @Bean
    public Student getStudent()
    {
        return new Student();
    }
    
    @Bean
    public DriverManagerDataSource getDriverManagerDataSource()
    {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        return driverManagerDataSource;
    }
    
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }
            
    @Bean
    public StudentDAOImpl getStudentDAOImpl(JdbcTemplate jdbcTemplate)
    {
        return  new StudentDAOImpl(jdbcTemplate);
    }
                    
}
