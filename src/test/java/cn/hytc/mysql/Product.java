package cn.hytc.mysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品类（测试用）
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Product {
    private String name;
    private Integer price;
}