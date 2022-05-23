package com.example.thymeleafdemo.DAO;


import com.example.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //method to sort by last name findallby orderby lastname asc
    public List<Employee> findAllByOrderByLastNameAsc();
}
