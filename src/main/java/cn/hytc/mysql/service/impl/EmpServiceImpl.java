package cn.hytc.mysql.service.impl;


import cn.hytc.mysql.entity.Emp;
import cn.hytc.mysql.entity.EmpExpr;
import cn.hytc.mysql.mapper.EmpExprMapper;
import cn.hytc.mysql.mapper.EmpMapper;
import cn.hytc.mysql.annotation.Log;
import cn.hytc.mysql.service.EmpService;
import cn.hytc.mysql.vo.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    public List<Emp> list() {
        return empMapper.list();
    }

    public PageResult<Emp> page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.list();
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Log(module = "员工管理", operation = "批量删除员工")
    @Transactional
    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);
    }

    @Log(module = "员工管理", operation = "新增员工")
    @Transactional
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Log(module = "员工管理", operation = "修改员工")
    @Transactional
    @Override
    public void updateById(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
            empExprMapper.insertBatch(exprList);
        }
    }
}