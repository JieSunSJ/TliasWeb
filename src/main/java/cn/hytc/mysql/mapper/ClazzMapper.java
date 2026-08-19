package cn.hytc.mysql.mapper;

import cn.hytc.mysql.entity.Clazz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;
@Mapper
public interface ClazzMapper {
    List<Clazz> list(@Param("name") String name, @Param("beginDate") LocalDate beginDate, @Param("endDate") LocalDate endDate);
}