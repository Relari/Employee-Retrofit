package com.pe.relari.employeeretrofit.business.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

  private String id;
  private String name;
  private String position;
  private String sex;
  private Double salary;
  private Boolean status;

}
