package cn.hytc.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {
    private Long total; //总记录数
    private List<Emp> rows; //当前页数据列表

    public PageResult(long total, List<Emp> rows) {
        this.total = total;
        this.rows = rows;
    }
}