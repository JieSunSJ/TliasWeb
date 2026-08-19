package cn.hytc.mysql.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSProperties {
    private String endpoint;
    private String bucketName;
    private String region;
    @PostConstruct
    public void init() {
        System.out.println("endpoint = " + endpoint);
        System.out.println("bucketName = " + bucketName);
        System.out.println("region = " + region);
    }
}