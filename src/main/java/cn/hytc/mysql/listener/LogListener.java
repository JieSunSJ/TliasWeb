package cn.hytc.mysql.listener;

import cn.hytc.mysql.entity.EmpLog;
import cn.hytc.mysql.event.LogEvent;
import cn.hytc.mysql.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LogListener {

    @Autowired
    private EmpLogService empLogService;

    @Async
    @EventListener
    public void handleLogEvent(LogEvent event) {
        String info = String.format("[%s] %s | %s | 耗时：%dms",
                event.getModule(),
                event.getOperation(),
                event.getDetail(),
                event.getCostTime());

        EmpLog empLog = new EmpLog(null, LocalDateTime.now(), info);
        empLogService.insertLog(empLog);
    }
}