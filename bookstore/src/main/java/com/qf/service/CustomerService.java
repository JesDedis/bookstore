package com.qf.service;

import com.qf.entity.Customer;

public interface CustomerService {

    Customer login(String username, String password);

    Integer register(Customer customer);
}
