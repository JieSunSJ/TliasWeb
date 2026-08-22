package cn.hytc.mysql.service;


import cn.hytc.mysql.vo.JobOption;
import cn.hytc.mysql.vo.StudentClazzOption;

import java.util.List;
import java.util.Map;

/**
 * 报表服务接口
 */
public interface ReportService {
    /**
     * 统计各个职位的员工人数
     * @return
     */
    JobOption getEmpJobData();
    /**
     * 统计学生性别
     * @return
     */
    List<Map> getStudentGenderData();

    /**
     * 统计员工性别
     * @return
     */
    List<Map> getEmpGenderData();
    /**
     * 统计学生学历
     * @return
     */
    List<Map> getStudentCollegeData();
    /**
     * 统计各班级学生人数
     * @return
     */
    StudentClazzOption getStudentCountData();
}