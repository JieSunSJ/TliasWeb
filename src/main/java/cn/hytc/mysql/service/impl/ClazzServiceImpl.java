package cn.hytc.mysql.service.impl;

import cn.hytc.mysql.entity.Clazz;
import cn.hytc.mysql.entity.PageResult;
import cn.hytc.mysql.mapper.ClazzMapper;
import cn.hytc.mysql.service.ClazzService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    // 班级列表分页查询
    @Override
    public List<Clazz> list(String name, LocalDate begin, LocalDate end) {
        return clazzMapper.list(name, begin, end);
    }

    @Override
    public PageResult<Clazz> page(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Clazz> list = clazzMapper.list(name, begin, end);
        PageInfo<Clazz> pageInfo = new PageInfo<>(list);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

}