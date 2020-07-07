package com.renzo.desarrrollo.api.employee.business.service;

import com.renzo.desarrrollo.api.employee.business.model.pojo.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {

  List<Employee> findAll() throws IOException;
}
