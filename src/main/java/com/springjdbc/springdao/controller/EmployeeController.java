package com.springjdbc.springdao.controller;

import com.springjdbc.springdao.dao.EmployeeDao;
import com.springjdbc.springdao.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(value="/getemplist")
    public List<Employee> getEmpList(){

        return employeeDao.getEmpList();
    }

    @GetMapping(value="/emp/{id}")
    public Employee getEmp(@PathVariable Integer id){
        return employeeDao.getEmployee(id);
    }

    @PostMapping(value="/save")
    public String addEmp(@RequestBody Employee employee){
        return employeeDao.addEmployee(employee);
    }

    @GetMapping(value="/joindata")
    public List<Map<String,Object>> getJoinEmp(){
        return employeeDao.getCombinedData();
    }
}
