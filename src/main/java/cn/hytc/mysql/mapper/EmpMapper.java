package cn.hytc.mysql.mapper;

import cn.hytc.mysql.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
    @Select("select e.*, d.name as dept_name from emp e left join dept d on e.dept_id = d.id")
    List<Emp> list();
    /**
     * 新增员工数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);
    /**
     * 批量删除员工信息
     */
    void deleteByIds(@Param("ids") List<Integer> ids);
    /**
     * 根据ID获取员工信息
     */
    Emp getById(@Param("id") Integer id);
    /**
     * 根据ID更新员工信息
     */
    void updateById(Emp emp);
    /**
     * 统计各个职位的员工人数
     */
    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();
    /**
     * 统计各个性别员工人数
     */
    @MapKey("gender")
    List<Map> countEmpGenderData();
}