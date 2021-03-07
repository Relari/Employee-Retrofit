package com.pe.relari.employeeretrofit.business.dao.repository;

import com.pe.relari.employeeretrofit.business.model.entity.EmployeeEntity;
import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface EmployeeApi {

  @GET("/application/firebase/v1/employees")
  Observable<List<EmployeeEntity>> findAll();

  @POST("/application/firebase/v1/employees")
  Completable save(@Body EmployeeEntity employeeEntity);

}
