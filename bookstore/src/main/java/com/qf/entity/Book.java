package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Integer id;
    private String bookname;
    private String author;
    private Double price;
    private Integer classid;
    private String descr;
    private String path;
}
