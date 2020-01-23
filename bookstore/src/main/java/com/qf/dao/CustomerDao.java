package com.qf.dao;

import com.qf.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao {

    Customer login(String username, String password);

    Integer regiter(Customer customer);
}
