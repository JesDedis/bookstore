package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Integer id;
    private Integer cid;
    private Integer uid;
    private String getid;
    private String backid;
    private Double oprice;
    private String status;
}
