package com.pe.relari.employeeretrofit.business.service;

import com.pe.relari.employeeretrofit.business.model.business.Employee;
import io.reactivex.Completable;
import io.reactivex.Observable;

public interface EmployeeService {

  Observable<Employee> findAll();

  Completable save(Employee employee);
}
