package com.renzo.desarrrollo.api.employee.business.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.renzo.desarrrollo.api.employee.business.model.pojo.Employee;
import com.renzo.desarrrollo.api.employee.business.repository.EmployeeRepository;
import com.renzo.desarrrollo.api.employee.business.service.EmployeeService;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  // @Autowired


  public static String baseUrl = "http://localhost:8106";

  // Retrofit retrofit = new Retrofit.Builder()
  // .baseUrl(baseUrl)
  // //.client(client)
  // .addConverterFactory(GsonConverterFactory.create())
  // //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
  // .build();

  OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
  Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create()).client(httpClient.build()).build();

  private EmployeeRepository employeeRepository = retrofit.create(EmployeeRepository.class);

  public EmployeeServiceImpl() {
    // HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    // interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    // OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    Gson gson = new GsonBuilder().setLenient().create();

  }

  @Override
  public List<Employee> findAll() throws IOException {
    return employeeRepository.findAll().execute().body();
  }
}
