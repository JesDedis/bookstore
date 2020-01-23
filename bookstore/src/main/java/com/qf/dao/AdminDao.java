package com.qf.dao;

import com.qf.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

    Admin login(String name, String password);
}
