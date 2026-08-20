package cn.hytc.mysql.service;


import cn.hytc.mysql.entity.EmpLog;

public interface EmpLogService {
    //记录新增员工日志
    public void insertLog(EmpLog empLog);
}