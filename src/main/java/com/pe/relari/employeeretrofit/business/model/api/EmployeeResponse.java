package com.pe.relari.employeeretrofit.business.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

  private String name;

  private String position;

  private String sex;

  private Double salary;

  private Boolean status;

}
