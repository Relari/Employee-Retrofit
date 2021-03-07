package com.pe.relari.employeeretrofit.controller;

import com.pe.relari.employeeretrofit.business.model.api.EmployeeRequest;
import com.pe.relari.employeeretrofit.business.model.api.EmployeeResponse;
import com.pe.relari.employeeretrofit.business.model.business.Employee;
import com.pe.relari.employeeretrofit.business.service.EmployeeService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping
  public Observable<EmployeeResponse> findAll() {
    return employeeService.findAll()
            .map(this::mapEmployeeResponse);
  }

  private EmployeeResponse mapEmployeeResponse(Employee employee) {
    return EmployeeResponse.builder()
            .position(employee.getPosition())
            .name(employee.getName())
            .sex(employee.getSex())
            .status(employee.getStatus())
            .salary(employee.getSalary())
            .build();
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public Completable save(@RequestBody EmployeeRequest employeeRequest) {
    return Single.fromCallable(() -> mapEmployee(employeeRequest))
            .flatMapCompletable(employeeService::save);
  }

  private Employee mapEmployee(EmployeeRequest employeeRequest) {
    return Employee.builder()
            .position(employeeRequest.getPosition())
            .name(employeeRequest.getName())
            .sex(employeeRequest.getSex())
            .status(Boolean.TRUE)
            .salary(employeeRequest.getSalary())
            .build();
  }

}
