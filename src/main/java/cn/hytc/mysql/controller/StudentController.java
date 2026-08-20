package cn.hytc.mysql.controller;

import cn.hytc.mysql.service.StudentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    /**
     * 分页查询学生信息
     * @return
     */
    @RequestMapping("/list")
    public String list() {
        return "students/list";
    }
}
