package com.yx1030.springboot_mybatis_generator_pagehelper_student.service;

import com.yx1030.springboot_mybatis_generator_pagehelper_student.pojo.Student;

import java.util.List;

public interface StudentService {
    /**
     * 列表
     * @param example
     * @return
     *
     */
    List<Student> selectByExample(Student example);
    int insert(Student record);



}
