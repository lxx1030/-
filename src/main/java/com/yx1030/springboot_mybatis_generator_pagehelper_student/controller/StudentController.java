package com.yx1030.springboot_mybatis_generator_pagehelper_student.controller;

import com.yx1030.springboot_mybatis_generator_pagehelper_student.pojo.Student;
import com.yx1030.springboot_mybatis_generator_pagehelper_student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;
    @RequestMapping("list")
    public ModelAndView list(ModelAndView mav, Student example){
        List<Student> list = service.selectByExample(example);
        mav.addObject("list",list);
        mav.setViewName("list");
        return mav;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(ModelAndView mav){
        mav.setViewName("add");
        return mav;

    }
    @RequestMapping("add")
    public String Add(ModelAndView mav, Student student, @RequestParam("tx")MultipartFile tx) throws IOException {
        String path = "F:\\idea-workspace\\springboot_mybatis_generator_pagehelper_student\\src\\main\\webapp\\img\\";
        File file = new File(path+tx.getOriginalFilename());
        tx.transferTo(file);
        student.setPhoto(tx.getOriginalFilename());
        service.insert(student);
        return "redirect:list";

    }

}
