package com.qf.dao;

import com.qf.entity.Book;
import com.qf.entity.QueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {

    List<Book> queryAll(QueryVo queryVo);
}
