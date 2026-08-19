package cn.hytc.mysql.controller;
import cn.hytc.mysql.entity.Clazz;
import cn.hytc.mysql.entity.PageResult;
import cn.hytc.mysql.entity.Result;
import cn.hytc.mysql.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clzzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result getClazzList(@RequestParam String name, @DateTimeFormat(pattern = "yyyy-M-d") LocalDate begin, @DateTimeFormat(pattern = "yyyy-M-d") LocalDate end, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer pageSize) {
        PageResult<Clazz> clazzList = clazzService.page(name, begin, end, page, pageSize);
        return Result.success(clazzList);
    }
}