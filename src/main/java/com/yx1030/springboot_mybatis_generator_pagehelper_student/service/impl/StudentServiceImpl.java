package com.yx1030.springboot_mybatis_generator_pagehelper_student.service.impl;

import com.yx1030.springboot_mybatis_generator_pagehelper_student.mapper.StudentMapper;
import com.yx1030.springboot_mybatis_generator_pagehelper_student.pojo.Student;
import com.yx1030.springboot_mybatis_generator_pagehelper_student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper mapper;

    @Override
    public List<Student> selectByExample(Student example) {
        return mapper.selectByExample(example);
    }

    @Override
    public int insert(Student record) {
        return mapper.insert(record);
    }
}
