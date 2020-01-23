package com.qf.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDao {

    List<Class> queryAll();
}
