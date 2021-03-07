package com.pe.relari.employeeretrofit.business.service.impl;

import com.pe.relari.employeeretrofit.business.dao.EmployeeDao;
import com.pe.relari.employeeretrofit.business.model.business.Employee;
import com.pe.relari.employeeretrofit.business.service.EmployeeService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeDao employeeDao;

  public Completable save(Employee employee) {
    return employeeDao.save(employee);
  }

  @Override
  public Observable<Employee> findAll() {
    return employeeDao.findAll();
  }

}
