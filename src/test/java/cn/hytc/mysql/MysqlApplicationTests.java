package cn.hytc.mysql;

import cn.hytc.mysql.entity.Emp;
import cn.hytc.mysql.utils.JwtUtils;
import cn.hytc.mysql.vo.PageResult;
import cn.hytc.mysql.mapper.EmpMapper;
import cn.hytc.mysql.service.impl.EmpServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    /**
     * 生成JWT
     */
    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 10);
        claims.put("username", "itheima");

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRjYXN0")
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 3600 * 1000))
                .compact();

        System.out.println(jwt);
    }
    /**
     * 解析JWT
     */
    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser().setSigningKey("aXRjYXN0")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTAsInVzZXJuYW1lIjoidGhlaW1hIiwiaWF0IjoxNjg2MjMwMjUyLCJleHAiOjE2ODY4MjUwMjJ9._q9kY9g79r6V9Dk9z4a49dS4j619g79r6V9Dk9z4a49dS4j619g")
                .getBody();
        System.out.println(claims);
    }
}