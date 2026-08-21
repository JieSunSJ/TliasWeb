package cn.hytc.mysql.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class LogEvent extends ApplicationEvent {
    private final String module;
    private final String operation;
    private final String detail;
    private final long costTime;

    public LogEvent(Object source, String module, String operation, String detail, long costTime) {
        super(source);
        this.module = module;
        this.operation = operation;
        this.detail = detail;
        this.costTime = costTime;
    }
}