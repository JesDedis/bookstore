package com.qf.service;

import com.qf.entity.Admin;

public interface AdminService {
    Admin login(String username, String password);
}
