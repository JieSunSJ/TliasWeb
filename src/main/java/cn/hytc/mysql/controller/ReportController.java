package cn.hytc.mysql.controller;

import cn.hytc.mysql.entity.JobOption;
import cn.hytc.mysql.vo.Result;
import cn.hytc.mysql.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计各个职位的员工人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }
    // 统计男生女生数量
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计男生女生数量");
        List<Map> list = reportService.getEmpGenderData();
        return Result.success(list);
    }
}