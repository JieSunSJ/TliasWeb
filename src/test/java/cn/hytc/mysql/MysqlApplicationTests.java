package cn.hytc.mysql;

import cn.hytc.mysql.entity.Emp;
import cn.hytc.mysql.vo.PageResult;
import cn.hytc.mysql.mapper.EmpMapper;
import cn.hytc.mysql.service.impl.EmpServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class MysqlApplicationTests {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpServiceImpl empService;

    @Test
    public void testList(){
        List<Emp> empList = empMapper.list();
        empList.forEach(System.out::println);
    }
    @Test
    public void testPage(){
        PageResult pageResult = empService.page(2, 5);
        System.out.println(pageResult);
    }
    @Test
    public void testSave(){
        Emp emp = new Emp();
        emp.setUsername("111");
        emp.setName("张三");
        emp.setGender(1);
        emp.setPhone("12345678901");
        emp.setJob(1); // Changed from emp.setJob("1");
        emp.setSalary(8000); // Changed from emp.setSalary(8000.00);
        emp.setImage("1.jpg");
        emp.setEntryDate(LocalDate.parse("2020-01-01"));
        emp.setDeptId(1);
        empService.save(emp);
    }
}