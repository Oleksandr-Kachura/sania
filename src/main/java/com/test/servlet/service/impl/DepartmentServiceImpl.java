package com.test.servlet.service.impl;

import com.test.servlet.dao.DepartmentDao;
import com.test.servlet.dao.impl.DepartmentDaoImpl;
import com.test.servlet.model.Department;

import com.test.servlet.service.DepartmentService;

import java.sql.SQLException;
import java.util.List;


public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao = new DepartmentDaoImpl();


    public List<Department> findAll() throws SQLException {
        return departmentDao.findAll();
    }


    public Department findDepartmentById(int id) throws SQLException {
        return departmentDao.findDepartmentById(id);
    }

    public Department findDepartmentByName(String name) throws SQLException {
        return departmentDao.findDepartmentByName(name.toString());
    }

    public void add (Department dep) throws SQLException{
        departmentDao.add(dep);
    }

    public void delete (Department dep) throws SQLException{departmentDao.delete(dep); }

    public void update (Department dep) throws SQLException{departmentDao.update(dep); }

}
