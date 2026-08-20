package cn.hytc.mysql.controller;

import cn.hytc.mysql.entity.Emp;
import cn.hytc.mysql.vo.PageResult;
import cn.hytc.mysql.vo.Result;
import cn.hytc.mysql.service.EmpService;
import cn.hytc.mysql.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private ReportService reportService;


    @RequestMapping("/list")
    public Result list() {
        return new Result(200, "success", empService.list());
    }

    @RequestMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        PageResult pageResult = empService.page(page, pageSize);
        return new Result(200, "success", pageResult);
    }

    /**
     * 添加员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        empService.save(emp);
        return Result.success(emp);
    }

    /**
     * 批量删除员工
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("批量删除员工: ids={} ", ids);
        empService.deleteByIds(ids);
        return Result.success("删除成功");
    }

    /**
     * 根据ID查询员工
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据ID查询员工: id={} ", id);
        return Result.success(empService.getById(id));
    }

    /**
     * 根据ID修改员工
     */
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("根据ID修改员工: emp={} ", emp);
        empService.updateById(emp);
        return Result.success("修改成功");
    }

}