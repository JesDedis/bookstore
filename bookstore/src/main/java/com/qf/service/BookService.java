package com.qf.service;

import com.qf.entity.Book;
import com.qf.entity.QueryVo;

import java.util.List;

public interface BookService {

    List<Book> queryAll(QueryVo queryVo);
}
