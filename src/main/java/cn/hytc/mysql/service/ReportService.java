package cn.hytc.mysql.service;

import cn.hytc.mysql.entity.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 统计各个职位的员工人数
     * @return
     */
    JobOption getEmpJobData();
    /**
     * 统计各个部门的员工人数
     * @return
     */
    List<Map> getEmpGenderData();
}