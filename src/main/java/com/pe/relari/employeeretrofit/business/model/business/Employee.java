package com.pe.relari.employeeretrofit.business.model.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

  private String name;
  private String position;
  private String sex;
  private Double salary;
  private Boolean status;

}
