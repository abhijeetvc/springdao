package com.springjdbc.springdao.repository;

import com.springjdbc.springdao.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {

    List<Employee> getEmpList();

    Employee getEmployee(Integer id);

    String addEmployee(Employee employee);

    List<Map<String,Object>> getCombinedData();
}
