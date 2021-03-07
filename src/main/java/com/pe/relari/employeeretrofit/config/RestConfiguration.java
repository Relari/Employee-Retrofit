package com.pe.relari.employeeretrofit.config;

import com.pe.relari.employeeretrofit.business.dao.repository.EmployeeApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Lazy
@Configuration
public class RestConfiguration {

  @Value("${application.http-client.employee.base-url}")
  private String uri;

  private Retrofit retrofit() {
    return new Retrofit.Builder()
        .baseUrl(uri)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }

  @Bean
  public EmployeeApi employeeRepository() {
    return retrofit().create(EmployeeApi.class);
  }
}
