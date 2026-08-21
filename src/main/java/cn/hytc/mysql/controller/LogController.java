package cn.hytc.mysql.controller;

import cn.hytc.mysql.entity.EmpLog;
import cn.hytc.mysql.service.EmpLogService;
import cn.hytc.mysql.vo.PageResult;
import cn.hytc.mysql.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private EmpLogService empLogService;

    /** 查询所有日志 */
    @GetMapping("/list")
    public Result list() {
        log.info("查询所有日志");
        List<EmpLog> list = empLogService.list();
        return Result.success(list);
    }

    /** 分页查询日志 */
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询日志: page={}, pageSize={}", page, pageSize);
        PageResult<EmpLog> pageResult = empLogService.page(page, pageSize);
        return Result.success(pageResult);
    }

    /** 删除日志 */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除日志: id={}", id);
        empLogService.deleteById(id);
        return Result.success("删除成功");
    }
}