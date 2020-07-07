package com.renzo.desarrrollo.api.employee.business.model.pojo;


import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Getter
@Setter
public class Employee implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "Id del Empleado", example = "1", required = false,
      dataType = "Integer", position = 1)
  private Integer idEmployee;

  @NotBlank
  @Size(max = 50)
  @ApiModelProperty(value = "Apellido Paterno del Empleado", example = "Lozano", required = true,
      dataType = "String", position = 2)
  private String apellidoPaterno;

  @NotBlank
  @Size(max = 50)
  @ApiModelProperty(value = "Apellido Materno del Empleado", example = "Lozano", required = true,
      dataType = "String", position = 3)
  private String apellidoMaterno;

  @NotBlank
  @Size(max = 50)
  @ApiModelProperty(value = "Nombre del Empleado", example = "Ricardo", required = true,
      dataType = "String", position = 4)
  private String nombre;

  @NotBlank
  @Size(max = 50)
  @ApiModelProperty(value = "Cargo del Empleado", example = "Administrador", required = true,
      dataType = "String", position = 5)
  private String cargo;

  @NotBlank
  @Size(max = 1)
  @ApiModelProperty(value = "Sexo del Empleado", example = "M", required = true,
      dataType = "String", position = 6)
  private String sexo;

  @NotNull
  @ApiModelProperty(value = "Sueldo del Empleado", example = "2500.00", required = true,
      dataType = "Double", position = 7)
  private Double sueldo;

  @NotBlank
  @Size(max = 1)
  @ApiModelProperty(value = "Status del Empleado", example = "1", required = true,
      dataType = "String", position = 8)
  private String status;
}
