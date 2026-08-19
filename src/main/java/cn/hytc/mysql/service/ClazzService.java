package cn.hytc.mysql.service;

import cn.hytc.mysql.entity.Clazz;
import cn.hytc.mysql.entity.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface ClazzService {
    List<Clazz> list(String name, LocalDate begin, LocalDate end);
    PageResult<Clazz> page(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize);
}