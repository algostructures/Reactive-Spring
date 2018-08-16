package com.reactivespring.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
public class EmployeeEvent {

    private Employee employee;
    private Date date;

}