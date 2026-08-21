package cn.hytc.mysql.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentClazzOption {
    private List<String> clazzList;
    private List<Long> countList;
}