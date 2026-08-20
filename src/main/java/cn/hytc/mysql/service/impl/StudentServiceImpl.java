package cn.hytc.mysql.service.impl;

import cn.hytc.mysql.mapper.StudentMapper;
import cn.hytc.mysql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
}
