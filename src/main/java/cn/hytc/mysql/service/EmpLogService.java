package cn.hytc.mysql.service;


import cn.hytc.mysql.entity.EmpLog;
import cn.hytc.mysql.vo.PageResult;

import java.util.List;

/**
 * 操作日志服务接口
 */
public interface EmpLogService {

    void insertLog(EmpLog empLog);

    List<EmpLog> list();

    PageResult<EmpLog> page(Integer page, Integer pageSize);

    void deleteById(Integer id);
}