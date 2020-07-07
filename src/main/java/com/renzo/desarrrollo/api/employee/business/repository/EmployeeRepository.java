package com.renzo.desarrrollo.api.employee.business.repository;

import com.renzo.desarrrollo.api.employee.business.model.pojo.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

// @Repository
public interface EmployeeRepository {

  @GET("/employees")
  // @Headers("Accept: application/stream+json")
  Call<List<Employee>> findAll();
}
