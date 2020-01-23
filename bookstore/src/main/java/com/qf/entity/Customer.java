package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Integer id;
    private String name;
    private String psw;
    private String phone;
    private String email;
    private String address;
}
