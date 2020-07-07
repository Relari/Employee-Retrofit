package com.renzo.desarrrollo.api.employee.controller;

import com.renzo.desarrrollo.api.employee.business.model.pojo.Employee;
import com.renzo.desarrrollo.api.employee.business.service.EmployeeService;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/retrofit/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping
  public List<Employee> findAll() throws IOException {
    return employeeService.findAll();
  }
}
