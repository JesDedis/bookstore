package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer id;
    private String cusid;
    private String bookid;
    private Integer num;
    private Book book;
}
