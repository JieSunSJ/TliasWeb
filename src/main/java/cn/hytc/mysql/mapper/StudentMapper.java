package cn.hytc.mysql.mapper;

import cn.hytc.mysql.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> list();
}
