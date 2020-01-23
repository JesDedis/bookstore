package com.qf.service.impl;

import com.qf.dao.AdminDao;
import com.qf.entity.Admin;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(String name, String password) {
        return adminDao.login(name,password);
    }
}
