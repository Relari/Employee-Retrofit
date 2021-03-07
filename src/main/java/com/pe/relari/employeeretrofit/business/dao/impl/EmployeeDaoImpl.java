package com.pe.relari.employeeretrofit.business.dao.impl;

import com.pe.relari.employeeretrofit.business.dao.repository.EmployeeApi;
import com.pe.relari.employeeretrofit.business.dao.EmployeeDao;
import com.pe.relari.employeeretrofit.business.model.business.Employee;
import com.pe.relari.employeeretrofit.business.model.entity.EmployeeEntity;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class EmployeeDaoImpl implements EmployeeDao {

  private final EmployeeApi employeeApi;

  @Override
  public Observable<Employee> findAll() {
    return employeeApi.findAll()
            .subscribeOn(Schedulers.io())
            .flatMapIterable(employeeEntities -> employeeEntities)
            .map(this::mapEmployee);
  }

  private Employee mapEmployee(EmployeeEntity employeeEntity) {
    return Employee.builder()
            .position(employeeEntity.getPosition())
            .name(employeeEntity.getName())
            .sex(employeeEntity.getSex())
            .status(employeeEntity.getStatus())
            .salary(employeeEntity.getSalary())
            .build();
  }

  @Override
  public Completable save(Employee employee) {
    return Single.fromCallable(() -> mapEmployeeEntity(employee))
            .flatMapCompletable(employeeApi::save)
            .subscribeOn(Schedulers.io());
  }

  private EmployeeEntity mapEmployeeEntity(Employee employee) {
    return EmployeeEntity.builder()
            .position(employee.getPosition())
            .name(employee.getName())
            .sex(employee.getSex())
            .status(employee.getStatus())
            .salary(employee.getSalary())
            .build();
  }
}
