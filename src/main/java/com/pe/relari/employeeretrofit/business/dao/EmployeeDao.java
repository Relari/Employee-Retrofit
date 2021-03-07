package com.pe.relari.employeeretrofit.business.dao;

import com.pe.relari.employeeretrofit.business.model.business.Employee;
import io.reactivex.Completable;
import io.reactivex.Observable;

public interface EmployeeDao {

  Observable<Employee> findAll();

  Completable save(Employee employee);

}
