package com.qf.service.impl;

import com.qf.dao.ClassDao;
import com.qf.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public List<Class> queryAll() {
        return classDao.queryAll();
    }
}
