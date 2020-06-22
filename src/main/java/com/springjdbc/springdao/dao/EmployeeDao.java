package com.springjdbc.springdao.dao;

import com.springjdbc.springdao.model.Employee;
import com.springjdbc.springdao.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getEmpList() {
        String sql="select * from employee";
        List<Employee> list=jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Employee.class));
        return list;
    }

    @Override
    public Employee getEmployee(Integer id) {
        String sql="select * from employee where id=?";
        Employee emp= (Employee) jdbcTemplate.queryForObject(sql,new Object[]{id},
                new BeanPropertyRowMapper(Employee.class));
        return emp;
    }

    @Override
    public String addEmployee(Employee employee) {
        String sql="insert into employee values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]
                {employee.getId(),employee.getName(),employee.getCity()});
        return "Employee added";
    }

    @Override
    public List<Map<String, Object>> getCombinedData() {
        String sql="select a.id,a.name,a.city,b.name as deptName from employee a,department b " +
                "where a.dept_id=b.id";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }

}

//Update and Delete operations
//Inserting into employee with reference of department
// Inserting data in multiple tables
