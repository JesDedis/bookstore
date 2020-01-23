package com.qf.service.impl;

import com.qf.dao.BookDao;
import com.qf.entity.Book;
import com.qf.entity.QueryVo;
import com.qf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> queryAll(QueryVo queryVo) {
        return bookDao.queryAll(queryVo);
    }
}
