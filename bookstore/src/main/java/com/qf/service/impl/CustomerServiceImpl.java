package com.qf.service.impl;

import com.qf.dao.CustomerDao;
import com.qf.entity.Customer;
import com.qf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer login(String username, String password) {
        return customerDao.login(username,password);
    }

    @Override
    public Integer register(Customer customer) {
        return customerDao.regiter(customer);
    }
}
