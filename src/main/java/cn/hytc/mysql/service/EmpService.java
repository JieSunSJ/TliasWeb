package cn.hytc.mysql.service;

import cn.hytc.mysql.entity.Emp;
import cn.hytc.mysql.entity.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmpService {
    List<Emp> list();

    PageResult page(Integer page, Integer pageSize);
    /**
     * 添加员工
     * @param emp
     */
    void save(Emp emp);

    void deleteByIds(List<Integer> ids);
    Emp getById(Integer id);
    void updateById(Emp emp);

}
